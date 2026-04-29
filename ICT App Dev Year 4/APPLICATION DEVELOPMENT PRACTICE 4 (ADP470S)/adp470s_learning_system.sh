#!/bin/bash

# ADP470S Data Structures & Algorithms Learning System
# Interactive progress tracker with quizzes and exams
# FIXED VERSION - Windows/Git Bash Compatible

# Colors for better UI
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
PURPLE='\033[0;35m'
CYAN='\033[0;36m'
NC='\033[0m' # No Color

# Data files - Use current directory for Windows compatibility
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROGRESS_FILE="$SCRIPT_DIR/.adp470s_progress.json"
QUIZ_SCORES_FILE="$SCRIPT_DIR/.adp470s_quiz_scores.json"

# Initialize progress file if it doesn't exist
initialize_data() {
    if [ ! -f "$PROGRESS_FILE" ]; then
        cat > "$PROGRESS_FILE" << 'INIT_EOF'
{
  "term1": {
    "week1": false, "week2": false, "week3": false, "week4": false,
    "week5": false, "week6": false, "week7": false, "exam": false
  },
  "term2": {
    "week1": false, "week2": false, "week3": false, "week4": false,
    "week5": false, "week6": false, "week7": false, "week8": false,
    "week9": false, "week10": false, "week11": false, "week12": false,
    "week13": false, "exam": false
  },
  "term3": {
    "week1": false, "week2": false, "week3": false, "week4": false,
    "week5": false, "week6": false, "week7": false, "week8": false,
    "project": false, "exam": false
  },
  "term4": {
    "week1": false, "week2": false, "week3": false, "week4": false,
    "week5": false, "week6": false, "exam": false
  }
}
INIT_EOF
    fi
    
    if [ ! -f "$QUIZ_SCORES_FILE" ]; then
        echo '{}' > "$QUIZ_SCORES_FILE"
    fi
}

# Function to read JSON value with error handling
get_progress() {
    local term=$1
    local week=$2
    
    # Ensure file exists
    if [ ! -f "$PROGRESS_FILE" ]; then
        echo "false"
        return
    fi
    
    python3 << PYEOF 2>/dev/null || echo "false"
import json
import sys

progress_file = r'''$PROGRESS_FILE'''

try:
    with open(progress_file, 'r') as f:
        data = json.load(f)
    result = data.get('$term', {}).get('$week', False)
    print('true' if result else 'false')
except Exception:
    print('false')
    sys.exit(1)
PYEOF
}

# Function to update JSON value
update_progress() {
    local term=$1
    local week=$2
    local value=$3
    
    # Ensure file exists
    if [ ! -f "$PROGRESS_FILE" ]; then
        initialize_data
    fi
    
    python3 << PYEOF
import json
import sys

progress_file = r'''$PROGRESS_FILE'''

try:
    with open(progress_file, 'r') as f:
        data = json.load(f)
except Exception:
    data = {"term1": {}, "term2": {}, "term3": {}, "term4": {}}

term = '$term'
week = '$week'
raw_value = '$value'

# Safely convert to Python boolean regardless of capitalisation
bool_value = raw_value.strip().lower() == 'true'

if term not in data:
    data[term] = {}

data[term][week] = bool_value

with open(progress_file, 'w') as f:
    json.dump(data, f, indent=2)
PYEOF
}

# Save quiz score
save_quiz_score() {
    local topic=$1
    local score=$2
    local total=$3
    local timestamp=$(date '+%Y-%m-%d %H:%M:%S')
    
    # Ensure file exists
    if [ ! -f "$QUIZ_SCORES_FILE" ]; then
        echo '{}' > "$QUIZ_SCORES_FILE"
    fi
    
    python3 << PYEOF
import json
import sys

quiz_file = r'''$QUIZ_SCORES_FILE'''

try:
    with open(quiz_file, 'r') as f:
        data = json.load(f)
except:
    data = {}
    
topic = '$topic'
if topic not in data:
    data[topic] = []
    
data[topic].append({
    'score': $score,
    'total': $total,
    'percentage': round(($score / $total) * 100, 2),
    'timestamp': '$timestamp'
})

with open(quiz_file, 'w') as f:
    json.dump(data, f, indent=2)
    
print("Score saved successfully!", file=sys.stderr)
PYEOF
}

# Clear screen function
clear_screen() {
    clear
    echo -e "${CYAN}╔══════════════════════════════════════════════════════════════╗${NC}"
    echo -e "${CYAN}║${NC}  ${PURPLE}ADP470S: Data Structures & Algorithms Learning System${NC}  ${CYAN}║${NC}"
    echo -e "${CYAN}╚══════════════════════════════════════════════════════════════╝${NC}"
    echo ""
}

# Display progress bar
show_progress_bar() {
    local term=$1
    local completed=0
    local total=0
    
    case $term in
        "term1") total=8 ;;
        "term2") total=14 ;;
        "term3") total=10 ;;
        "term4") total=7 ;;
    esac
    
    for i in $(seq 1 $total); do
        local key="week$i"
        if [ $i -eq 9 ] && [ "$term" == "term3" ]; then
            key="project"
        elif [ $i -eq $total ]; then
            key="exam"
        fi
        
        local status=$(get_progress "$term" "$key")
        if [ "$status" == "true" ]; then
            ((completed++))
        fi
    done
    
    local percentage=$((completed * 100 / total))
    local filled=$((completed * 50 / total))
    local empty=$((50 - filled))
    
    echo -ne "${YELLOW}Progress: [${NC}"
    for ((i=0; i<filled; i++)); do echo -ne "${GREEN}█${NC}"; done
    for ((i=0; i<empty; i++)); do echo -ne "░"; done
    echo -e "${YELLOW}] ${percentage}% (${completed}/${total})${NC}"
    echo ""
}

# Main menu
main_menu() {
    clear_screen
    echo -e "${BLUE}Select a term to study:${NC}"
    echo ""
    echo -e "  ${GREEN}1)${NC} Term 1: Algorithms & Complexity (10%)"
    show_progress_bar "term1"
    echo ""
    echo -e "  ${GREEN}2)${NC} Term 2: Stacks, Queues, Trees & Sorting (35%)"
    show_progress_bar "term2"
    echo ""
    echo -e "  ${GREEN}3)${NC} Term 3: Graphs & Hashing (20% + Project)"
    show_progress_bar "term3"
    echo ""
    echo -e "  ${GREEN}4)${NC} Term 4: Advanced Topics & Review (35%)"
    show_progress_bar "term4"
    echo ""
    echo -e "  ${YELLOW}5)${NC} View All Progress & Scores"
    echo -e "  ${YELLOW}6)${NC} Reset All Progress"
    echo -e "  ${RED}0)${NC} Exit"
    echo ""
    echo -n "Choice: "
    read choice
    
    case $choice in
        1) term1_menu ;;
        2) term2_menu ;;
        3) term3_menu ;;
        4) term4_menu ;;
        5) view_all_progress ;;
        6) reset_progress ;;
        0) exit 0 ;;
        *) echo -e "${RED}Invalid choice${NC}"; sleep 1; main_menu ;;
    esac
}

# Term 1 Menu
term1_menu() {
    while true; do
        clear_screen
        echo -e "${BLUE}═══ TERM 1: Algorithms & Complexity (Assessment Weight: 10%) ═══${NC}"
        echo ""
        show_progress_bar "term1"
        echo ""
        
        # Display weeks with checkboxes
        for i in 1 2 3 4 5 6 7; do
            local status=$(get_progress "term1" "week$i")
            local checkbox="[ ]"
            if [ "$status" == "true" ]; then
                checkbox="${GREEN}[✓]${NC}"
            fi
            
            case $i in
                1) echo -e "  $checkbox ${GREEN}1)${NC} Week 1: Introduction to Algorithms & Complexity" ;;
                2) echo -e "  $checkbox ${GREEN}2)${NC} Week 2: Recursion vs Iteration (Factorial & Fibonacci)" ;;
                3) echo -e "  $checkbox ${GREEN}3)${NC} Week 3: Algorithm Complexity (Linear & Binary Search)" ;;
                4) echo -e "  $checkbox ${GREEN}4)${NC} Week 4: Bubble Sort & Complexity Analysis" ;;
                5) echo -e "  $checkbox ${GREEN}5)${NC} Week 5: 2D & Multidimensional Arrays" ;;
                6) echo -e "  $checkbox ${GREEN}6)${NC} Week 6: Singly Linked Lists" ;;
                7) echo -e "  $checkbox ${GREEN}7)${NC} Week 7: Doubly & Circular Linked Lists" ;;
            esac
        done
        
        local exam_status=$(get_progress "term1" "exam")
        local exam_checkbox="[ ]"
        if [ "$exam_status" == "true" ]; then
            exam_checkbox="${GREEN}[✓]${NC}"
        fi
        echo -e "  $exam_checkbox ${YELLOW}8)${NC} Practice Test 1 (10%)"
        echo ""
        echo -e "  ${CYAN}9)${NC} Take Quiz on Current Topic"
        echo -e "  ${RED}0)${NC} Back to Main Menu"
        echo ""
        echo -n "Choice: "
        read choice
        
        if [ "$choice" == "0" ]; then
            main_menu
            return
        elif [ "$choice" == "9" ]; then
            echo -n "Enter week number (1-7) for quiz: "
            read week_num
            if [[ "$week_num" =~ ^[0-9]+$ ]] && [ "$week_num" -ge 1 ] && [ "$week_num" -le 7 ]; then
                take_term1_quiz $week_num
            else
                echo -e "${RED}Invalid week number. Please enter 1-7.${NC}"; sleep 1
            fi
        elif [ "$choice" == "8" ]; then
            take_term1_exam
        elif [[ "$choice" =~ ^[0-9]+$ ]] && [ "$choice" -ge 1 ] && [ "$choice" -le 7 ]; then
            toggle_completion "term1" "week$choice"
        fi
    done
}

# Term 2 Menu
term2_menu() {
    while true; do
        clear_screen
        echo -e "${BLUE}═══ TERM 2: Stacks, Queues, Trees & Sorting (Assessment Weight: 35%) ═══${NC}"
        echo ""
        show_progress_bar "term2"
        echo ""
        
        for i in 1 2 3 4 5 6 7 8 9 10 11 12 13; do
            local status=$(get_progress "term2" "week$i")
            local checkbox="[ ]"
            if [ "$status" == "true" ]; then
                checkbox="${GREEN}[✓]${NC}"
            fi
            
            case $i in
                1) echo -e "  $checkbox ${GREEN}$i)${NC} Week 1: Review Term 1 Exercises" ;;
                2) echo -e "  $checkbox ${GREEN}$i)${NC} Week 2: Exercises Review Session" ;;
                3) echo -e "  $checkbox ${GREEN}$i)${NC} Week 3: Stack Operations & Recursion Revisited" ;;
                4) echo -e "  $checkbox ${GREEN}$i)${NC} Week 4: Queue Operations & Circular Queues" ;;
                5) echo -e "  $checkbox ${GREEN}$i)${NC} Week 5: Priority Queues" ;;
                6) echo -e "  $checkbox ${GREEN}$i)${NC} Week 6: Binary Trees & Traversals" ;;
                7) echo -e "  $checkbox ${GREEN}$i)${NC} Week 7: AVL Trees (Height Balanced)" ;;
                8) echo -e "  $checkbox ${GREEN}$i)${NC} Week 8: Short Test Review" ;;
                9) echo -e "  $checkbox ${GREEN}$i)${NC} Week 9: Sorting Algorithms I (Selection, Insertion)" ;;
                10) echo -e "  $checkbox ${GREEN}$i)${NC} Week 10: Sorting Algorithms II (Merge Sort)" ;;
                11) echo -e "  $checkbox ${GREEN}$i)${NC} Week 11: Sorting Algorithms III (Quick Sort)" ;;
                12) echo -e "  $checkbox ${GREEN}$i)${NC} Week 12: Sorting Algorithms IV (Heap Sort)" ;;
                13) echo -e "  $checkbox ${GREEN}$i)${NC} Week 13: Algorithm Analysis & Comparison" ;;
            esac
        done
        
        local exam_status=$(get_progress "term2" "exam")
        local exam_checkbox="[ ]"
        if [ "$exam_status" == "true" ]; then
            exam_checkbox="${GREEN}[✓]${NC}"
        fi
        echo -e "  $exam_checkbox ${YELLOW}14)${NC} Practice Test 2 (35%)"
        echo ""
        echo -e "  ${CYAN}15)${NC} Take Quiz on Current Topic"
        echo -e "  ${RED}0)${NC} Back to Main Menu"
        echo ""
        echo -n "Choice: "
        read choice
        
        if [ "$choice" == "0" ]; then
            main_menu
            return
        elif [ "$choice" == "15" ]; then
            echo -n "Enter week number (1-13) for quiz: "
            read week_num
            if [[ "$week_num" =~ ^[0-9]+$ ]] && [ "$week_num" -ge 1 ] && [ "$week_num" -le 13 ]; then
                take_term2_quiz $week_num
            else
                echo -e "${RED}Invalid week number. Please enter 1-13.${NC}"; sleep 1
            fi
        elif [ "$choice" == "14" ]; then
            take_term2_exam
        elif [[ "$choice" =~ ^[0-9]+$ ]] && [ "$choice" -ge 1 ] && [ "$choice" -le 13 ]; then
            toggle_completion "term2" "week$choice"
        fi
    done
}

# Term 3 Menu
term3_menu() {
    while true; do
        clear_screen
        echo -e "${BLUE}═══ TERM 3: Graphs & Hashing (Assessment Weight: 20% + Project) ═══${NC}"
        echo ""
        show_progress_bar "term3"
        echo ""
        
        for i in 1 2 3 4 5 6 7 8; do
            local status=$(get_progress "term3" "week$i")
            local checkbox="[ ]"
            if [ "$status" == "true" ]; then
                checkbox="${GREEN}[✓]${NC}"
            fi
            
            case $i in
                1) echo -e "  $checkbox ${GREEN}$i)${NC} Week 1: Introduction to Graphs & Representations" ;;
                2) echo -e "  $checkbox ${GREEN}$i)${NC} Week 2: Graph Traversal: BFS & DFS" ;;
                3) echo -e "  $checkbox ${GREEN}$i)${NC} Week 3: Advanced Graph Traversal" ;;
                4) echo -e "  $checkbox ${GREEN}$i)${NC} Week 4: Short Test" ;;
                5) echo -e "  $checkbox ${GREEN}$i)${NC} Week 5: Shortest Path: Prim's & Dijkstra" ;;
                6) echo -e "  $checkbox ${GREEN}$i)${NC} Week 6: Kruskal's, Floyd-Warshall & Disjoint Sets" ;;
                7) echo -e "  $checkbox ${GREEN}$i)${NC} Week 7: Hashing Techniques" ;;
                8) echo -e "  $checkbox ${GREEN}$i)${NC} Week 8: Project Work" ;;
            esac
        done
        
        local project_status=$(get_progress "term3" "project")
        local project_checkbox="[ ]"
        if [ "$project_status" == "true" ]; then
            project_checkbox="${GREEN}[✓]${NC}"
        fi
        echo -e "  $project_checkbox ${PURPLE}9)${NC} Individual Project Submission"
        
        local exam_status=$(get_progress "term3" "exam")
        local exam_checkbox="[ ]"
        if [ "$exam_status" == "true" ]; then
            exam_checkbox="${GREEN}[✓]${NC}"
        fi
        echo -e "  $exam_checkbox ${YELLOW}10)${NC} Practice Test 3 (20%)"
        echo ""
        echo -e "  ${CYAN}11)${NC} Take Quiz on Current Topic"
        echo -e "  ${RED}0)${NC} Back to Main Menu"
        echo ""
        echo -n "Choice: "
        read choice
        
        if [ "$choice" == "0" ]; then
            main_menu
            return
        elif [ "$choice" == "11" ]; then
            echo -n "Enter week number (1-8) for quiz: "
            read week_num
            if [[ "$week_num" =~ ^[0-9]+$ ]] && [ "$week_num" -ge 1 ] && [ "$week_num" -le 8 ]; then
                take_term3_quiz $week_num
            else
                echo -e "${RED}Invalid week number. Please enter 1-8.${NC}"; sleep 1
            fi
        elif [ "$choice" == "10" ]; then
            take_term3_exam
        elif [ "$choice" == "9" ]; then
            toggle_completion "term3" "project"
        elif [[ "$choice" =~ ^[0-9]+$ ]] && [ "$choice" -ge 1 ] && [ "$choice" -le 8 ]; then
            toggle_completion "term3" "week$choice"
        fi
    done
}

# Term 4 Menu
term4_menu() {
    while true; do
        clear_screen
        echo -e "${BLUE}═══ TERM 4: Advanced Topics & Final Review (Assessment Weight: 35%) ═══${NC}"
        echo ""
        show_progress_bar "term4"
        echo ""
        
        for i in 1 2 3 4 5 6; do
            local status=$(get_progress "term4" "week$i")
            local checkbox="[ ]"
            if [ "$status" == "true" ]; then
                checkbox="${GREEN}[✓]${NC}"
            fi
            
            case $i in
                1) echo -e "  $checkbox ${GREEN}$i)${NC} Week 1: GPS & Bitmap Data Structures" ;;
                2) echo -e "  $checkbox ${GREEN}$i)${NC} Week 2: Practical Exercises" ;;
                3) echo -e "  $checkbox ${GREEN}$i)${NC} Week 3: Parity Bits, Error Detection & CRC" ;;
                4) echo -e "  $checkbox ${GREEN}$i)${NC} Week 4: Comprehensive Review & Clarification" ;;
                5) echo -e "  $checkbox ${GREEN}$i)${NC} Week 5: Final Assessment Preparation" ;;
                6) echo -e "  $checkbox ${GREEN}$i)${NC} Week 6: Sick Test Week (Makeup Assessments)" ;;
            esac
        done
        
        local exam_status=$(get_progress "term4" "exam")
        local exam_checkbox="[ ]"
        if [ "$exam_status" == "true" ]; then
            exam_checkbox="${GREEN}[✓]${NC}"
        fi
        echo -e "  $exam_checkbox ${YELLOW}7)${NC} Final Test 4 (35%)"
        echo ""
        echo -e "  ${CYAN}8)${NC} Take Quiz on Current Topic"
        echo -e "  ${RED}0)${NC} Back to Main Menu"
        echo ""
        echo -n "Choice: "
        read choice
        
        if [ "$choice" == "0" ]; then
            main_menu
            return
        elif [ "$choice" == "8" ]; then
            echo -n "Enter week number (1-6) for quiz: "
            read week_num
            if [[ "$week_num" =~ ^[0-9]+$ ]] && [ "$week_num" -ge 1 ] && [ "$week_num" -le 6 ]; then
                take_term4_quiz $week_num
            else
                echo -e "${RED}Invalid week number. Please enter 1-6.${NC}"; sleep 1
            fi
        elif [ "$choice" == "7" ]; then
            take_term4_exam
        elif [[ "$choice" =~ ^[0-9]+$ ]] && [ "$choice" -ge 1 ] && [ "$choice" -le 6 ]; then
            toggle_completion "term4" "week$choice"
        fi
    done
}

# Toggle completion status
toggle_completion() {
    local term=$1
    local week=$2
    local current=$(get_progress "$term" "$week")
    
    if [ "$current" == "true" ]; then
        update_progress "$term" "$week" "False"
        echo -e "${YELLOW}Marked as incomplete${NC}"
    else
        update_progress "$term" "$week" "True"
        echo -e "${GREEN}Marked as complete!${NC}"
    fi
    sleep 1
}

# Quiz for Term 1
take_term1_quiz() {
    local week=$1
    clear_screen
    echo -e "${CYAN}═══ Term 1 Week $week Quiz ═══${NC}"
    echo ""
    
    local score=0
    local total=5
    
    case $week in
        1)
            echo "Q1: What is the primary purpose of algorithm analysis?"
            echo "1) To write code faster"
            echo "2) To evaluate efficiency and performance"
            echo "3) To make code look better"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            echo ""
            
            echo "Q2: What is Big O notation used for?"
            echo "1) Measuring actual runtime"
            echo "2) Describing asymptotic upper bound"
            echo "3) Counting lines of code"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            echo ""
            
            echo "Q3: Which complexity class is most efficient?"
            echo "1) O(n²)"
            echo "2) O(log n)"
            echo "3) O(n)"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            echo ""
            
            echo "Q4: An algorithm with O(1) time complexity is:"
            echo "1) Constant time"
            echo "2) Linear time"
            echo "3) Logarithmic time"
            read -p "Answer (1-3): " ans
            [ "$ans" == "1" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 1${NC}"
            echo ""
            
            echo "Q5: What does 'best case' complexity represent?"
            echo "1) Average performance"
            echo "2) Worst possible performance"
            echo "3) Optimal input scenario"
            read -p "Answer (1-3): " ans
            [ "$ans" == "3" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 3${NC}"
            ;;
        2)
            echo "Q1: Recursion requires:"
            echo "1) A base case"
            echo "2) Loops"
            echo "3) Arrays"
            read -p "Answer (1-3): " ans
            [ "$ans" == "1" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 1${NC}"
            echo ""
            
            echo "Q2: Factorial of 5 (5!) equals:"
            echo "1) 25"
            echo "2) 120"
            echo "3) 720"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            echo ""
            
            echo "Q3: Fibonacci sequence starts with:"
            echo "1) 1, 1, 2, 3, 5"
            echo "2) 0, 1, 1, 2, 3"
            echo "3) 1, 2, 3, 5, 8"
            read -p "Answer (1-3): " ans
            [ "$ans" == "1" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 1${NC}"
            echo ""
            
            echo "Q4: Recursive solutions typically use more:"
            echo "1) CPU time"
            echo "2) Stack space"
            echo "3) Disk space"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            echo ""
            
            echo "Q5: Iteration uses:"
            echo "1) Function calls"
            echo "2) Loops"
            echo "3) Recursion"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            ;;
        3)
            echo "Q1: Linear search time complexity is:"
            echo "1) O(1)"
            echo "2) O(log n)"
            echo "3) O(n)"
            read -p "Answer (1-3): " ans
            [ "$ans" == "3" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 3${NC}"
            echo ""
            
            echo "Q2: Binary search requires:"
            echo "1) Sorted array"
            echo "2) Linked list"
            echo "3) Hash table"
            read -p "Answer (1-3): " ans
            [ "$ans" == "1" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 1${NC}"
            echo ""
            
            echo "Q3: Binary search time complexity is:"
            echo "1) O(n)"
            echo "2) O(log n)"
            echo "3) O(n²)"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            echo ""
            
            echo "Q4: In binary search, each iteration eliminates:"
            echo "1) One element"
            echo "2) Half the elements"
            echo "3) All elements"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            echo ""
            
            echo "Q5: Linear search is preferred when:"
            echo "1) Array is sorted"
            echo "2) Array is small or unsorted"
            echo "3) Never"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            ;;
        4)
            echo "Q1: Bubble sort time complexity (worst case):"
            echo "1) O(n)"
            echo "2) O(n log n)"
            echo "3) O(n²)"
            read -p "Answer (1-3): " ans
            [ "$ans" == "3" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 3${NC}"
            echo ""
            
            echo "Q2: Bubble sort works by:"
            echo "1) Dividing array"
            echo "2) Swapping adjacent elements"
            echo "3) Building a heap"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            echo ""
            
            echo "Q3: Best case for bubble sort occurs when:"
            echo "1) Array is reversed"
            echo "2) Array is already sorted"
            echo "3) Array is random"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            echo ""
            
            echo "Q4: Bubble sort is a:"
            echo "1) Stable sort"
            echo "2) Unstable sort"
            echo "3) In-place only"
            read -p "Answer (1-3): " ans
            [ "$ans" == "1" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 1${NC}"
            echo ""
            
            echo "Q5: Number of passes in bubble sort for n elements:"
            echo "1) n"
            echo "2) n-1"
            echo "3) n²"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            ;;
        5)
            echo "Q1: A 2D array is also known as:"
            echo "1) Matrix"
            echo "2) Vector"
            echo "3) Linked list"
            read -p "Answer (1-3): " ans
            [ "$ans" == "1" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 1${NC}"
            echo ""
            
            echo "Q2: In Java, 2D arrays are stored as:"
            echo "1) Continuous memory"
            echo "2) Array of arrays"
            echo "3) Linked structure"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            echo ""
            
            echo "Q3: Element at row i, column j is accessed as:"
            echo "1) array[i,j]"
            echo "2) array[i][j]"
            echo "3) array(i)(j)"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            echo ""
            
            echo "Q4: Time to access any element in 2D array:"
            echo "1) O(1)"
            echo "2) O(n)"
            echo "3) O(n²)"
            read -p "Answer (1-3): " ans
            [ "$ans" == "1" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 1${NC}"
            echo ""
            
            echo "Q5: 3D arrays can represent:"
            echo "1) Only mathematical matrices"
            echo "2) Volumes or multi-dimensional data"
            echo "3) Cannot be used"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            ;;
        6)
            echo "Q1: Main advantage of linked list over array:"
            echo "1) Faster access"
            echo "2) Dynamic size"
            echo "3) Less memory"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            echo ""
            
            echo "Q2: Each node in singly linked list contains:"
            echo "1) Data only"
            echo "2) Data and next pointer"
            echo "3) Data and two pointers"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            echo ""
            
            echo "Q3: Inserting at beginning of linked list is:"
            echo "1) O(1)"
            echo "2) O(n)"
            echo "3) O(log n)"
            read -p "Answer (1-3): " ans
            [ "$ans" == "1" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 1${NC}"
            echo ""
            
            echo "Q4: Finding an element in unsorted linked list is:"
            echo "1) O(1)"
            echo "2) O(log n)"
            echo "3) O(n)"
            read -p "Answer (1-3): " ans
            [ "$ans" == "3" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 3${NC}"
            echo ""
            
            echo "Q5: Head pointer points to:"
            echo "1) Last node"
            echo "2) First node"
            echo "3) Middle node"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            ;;
        7)
            echo "Q1: Doubly linked list has pointers for:"
            echo "1) Next only"
            echo "2) Previous only"
            echo "3) Both next and previous"
            read -p "Answer (1-3): " ans
            [ "$ans" == "3" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 3${NC}"
            echo ""
            
            echo "Q2: Circular linked list's last node points to:"
            echo "1) NULL"
            echo "2) First node"
            echo "3) Middle node"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            echo ""
            
            echo "Q3: Doubly linked list allows traversal:"
            echo "1) Forward only"
            echo "2) Backward only"
            echo "3) Both directions"
            read -p "Answer (1-3): " ans
            [ "$ans" == "3" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 3${NC}"
            echo ""
            
            echo "Q4: Circular list is useful for:"
            echo "1) Round-robin scheduling"
            echo "2) Stack implementation"
            echo "3) Sorting"
            read -p "Answer (1-3): " ans
            [ "$ans" == "1" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 1${NC}"
            echo ""
            
            echo "Q5: Disadvantage of doubly linked list:"
            echo "1) Slower insertion"
            echo "2) More memory per node"
            echo "3) Cannot delete"
            read -p "Answer (1-3): " ans
            [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
            ;;
    esac
    
    echo ""
    echo -e "${CYAN}═══════════════════════════${NC}"
    echo -e "Score: ${GREEN}$score${NC}/$total ($(( score * 100 / total ))%)"
    echo -e "${CYAN}═══════════════════════════${NC}"
    
    save_quiz_score "Term1_Week$week" $score $total
    
    echo ""
    read -p "Press Enter to continue..."
}

# Placeholder quiz functions for other terms
take_term2_quiz() {
    local week=$1
    clear_screen
    echo -e "${CYAN}═══ Term 2 Week $week Quiz ═══${NC}"
    echo ""
    echo "Quiz questions for Term 2 Week $week coming soon!"
    echo "You can add questions by editing the script."
    echo ""
    read -p "Press Enter to continue..."
}

take_term3_quiz() {
    local week=$1
    clear_screen
    echo -e "${CYAN}═══ Term 3 Week $week Quiz ═══${NC}"
    echo ""
    echo "Quiz questions for Term 3 Week $week coming soon!"
    echo "You can add questions by editing the script."
    echo ""
    read -p "Press Enter to continue..."
}

take_term4_quiz() {
    local week=$1
    clear_screen
    echo -e "${CYAN}═══ Term 4 Week $week Quiz ═══${NC}"
    echo ""
    echo "Quiz questions for Term 4 Week $week coming soon!"
    echo "You can add questions by editing the script."
    echo ""
    read -p "Press Enter to continue..."
}

# Exam functions
take_term1_exam() {
    clear_screen
    echo -e "${YELLOW}═══ TERM 1 PRACTICE EXAM (10% Weight) ═══${NC}"
    echo ""
    echo "This exam covers all Term 1 topics."
    echo "You should complete all weekly topics before taking this exam."
    echo ""
    read -p "Ready to start? (y/n): " ready
    
    if [ "$ready" != "y" ]; then
        return
    fi
    
    local score=0
    local total=10
    
    # Sample exam questions
    echo ""
    echo "Q1: What is the time complexity of binary search?"
    echo "1) O(n)"
    echo "2) O(log n)"
    echo "3) O(n²)"
    read -p "Answer: " ans
    [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
    echo ""
    
    echo "Q2: Which requires more space - recursion or iteration?"
    echo "1) Recursion"
    echo "2) Iteration"
    echo "3) Both equal"
    read -p "Answer: " ans
    [ "$ans" == "1" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 1${NC}"
    echo ""
    
    echo "Q3: Best case time complexity of bubble sort:"
    echo "1) O(n)"
    echo "2) O(n log n)"
    echo "3) O(n²)"
    read -p "Answer: " ans
    [ "$ans" == "1" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 1${NC}"
    echo ""
    
    echo "Q4: Doubly linked list has how many pointers per node?"
    echo "1) 1"
    echo "2) 2"
    echo "3) 3"
    read -p "Answer: " ans
    [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
    echo ""
    
    echo "Q5: O(log n) is faster than O(n)?"
    echo "1) True"
    echo "2) False"
    echo "3) Depends"
    read -p "Answer: " ans
    [ "$ans" == "1" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 1${NC}"
    echo ""
    
    echo "Q6: Arrays have O(1) access time?"
    echo "1) True"
    echo "2) False"
    echo "3) Sometimes"
    read -p "Answer: " ans
    [ "$ans" == "1" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 1${NC}"
    echo ""
    
    echo "Q7: Linked lists are better than arrays for:"
    echo "1) Random access"
    echo "2) Frequent insertions/deletions"
    echo "3) Sorting"
    read -p "Answer: " ans
    [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
    echo ""
    
    echo "Q8: Fibonacci using recursion has what complexity?"
    echo "1) O(n)"
    echo "2) O(2^n)"
    echo "3) O(log n)"
    read -p "Answer: " ans
    [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
    echo ""
    
    echo "Q9: Circular linked list's advantage:"
    echo "1) Faster access"
    echo "2) Can traverse from any node to any other"
    echo "3) Uses less memory"
    read -p "Answer: " ans
    [ "$ans" == "2" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 2${NC}"
    echo ""
    
    echo "Q10: 2D array access time:"
    echo "1) O(1)"
    echo "2) O(n)"
    echo "3) O(n²)"
    read -p "Answer: " ans
    [ "$ans" == "1" ] && ((score++)) && echo -e "${GREEN}Correct!${NC}" || echo -e "${RED}Wrong. Correct: 1${NC}"
    
    echo ""
    echo -e "${CYAN}═══════════════════════════${NC}"
    echo -e "Final Score: ${GREEN}$score${NC}/$total ($(( score * 100 / total ))%)"
    echo -e "${CYAN}═══════════════════════════${NC}"
    
    save_quiz_score "Term1_Exam" $score $total
    update_progress "term1" "exam" "True"
    
    echo ""
    read -p "Press Enter to continue..."
}

take_term2_exam() {
    clear_screen
    echo -e "${YELLOW}═══ TERM 2 PRACTICE EXAM (35% Weight) ═══${NC}"
    echo ""
    echo "This is a major assessment worth 35%!"
    echo "Exam questions coming soon. You can add them by editing the script."
    echo ""
    update_progress "term2" "exam" "True"
    read -p "Press Enter to continue..."
}

take_term3_exam() {
    clear_screen
    echo -e "${YELLOW}═══ TERM 3 PRACTICE EXAM (20% Weight) ═══${NC}"
    echo ""
    echo "Exam questions coming soon. You can add them by editing the script."
    echo ""
    update_progress "term3" "exam" "True"
    read -p "Press Enter to continue..."
}

take_term4_exam() {
    clear_screen
    echo -e "${YELLOW}═══ TERM 4 FINAL EXAM (35% Weight) ═══${NC}"
    echo ""
    echo "This is a major assessment worth 35%!"
    echo "Exam questions coming soon. You can add them by editing the script."
    echo ""
    update_progress "term4" "exam" "True"
    read -p "Press Enter to continue..."
}

# View all progress
view_all_progress() {
    clear_screen
    echo -e "${CYAN}═══ YOUR OVERALL PROGRESS ═══${NC}"
    echo ""
    
    echo -e "${BLUE}Term 1 (10%):${NC}"
    show_progress_bar "term1"
    echo ""
    
    echo -e "${BLUE}Term 2 (35%):${NC}"
    show_progress_bar "term2"
    echo ""
    
    echo -e "${BLUE}Term 3 (20% + Project):${NC}"
    show_progress_bar "term3"
    echo ""
    
    echo -e "${BLUE}Term 4 (35%):${NC}"
    show_progress_bar "term4"
    echo ""
    
    echo -e "${YELLOW}═══ RECENT QUIZ SCORES ═══${NC}"
    if [ -f "$QUIZ_SCORES_FILE" ]; then
        python3 << PYEOF
import json
import sys

quiz_file = r'''$QUIZ_SCORES_FILE'''

try:
    with open(quiz_file, 'r') as f:
        scores = json.load(f)
    if not scores:
        print("No quiz scores yet")
    else:
        for topic, attempts in scores.items():
            if attempts:
                latest = attempts[-1]
                print(f"{topic}: {latest['score']}/{latest['total']} ({latest['percentage']}%) - {latest['timestamp']}")
except Exception as e:
    print("No quiz scores yet")
PYEOF
    else
        echo "No quiz scores yet"
    fi
    
    echo ""
    read -p "Press Enter to continue..."
    main_menu
}

# Reset progress
reset_progress() {
    clear_screen
    echo -e "${RED}WARNING: This will delete all your progress!${NC}"
    read -p "Are you sure? (yes/no): " confirm
    
    if [ "$confirm" == "yes" ]; then
        rm -f "$PROGRESS_FILE" "$QUIZ_SCORES_FILE"
        initialize_data
        echo -e "${GREEN}Progress reset successfully!${NC}"
        sleep 2
    fi
    main_menu
}

# Main execution
echo "Initializing ADP470S Learning System..."
initialize_data
echo "Ready!"
sleep 1
main_menu