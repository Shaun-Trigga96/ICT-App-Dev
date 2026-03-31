# ADP470S Learning System - Quick Start Guide

## What You'll Get

This learning system includes:

1. **Interactive Bash Script** - Track progress, take quizzes, and practice exams
2. **Comprehensive Study Schedule** - 11-month detailed plan aligned with your course
3. **Weekly Learning Targets** - Specific goals for each week
4. **Assessment Preparation** - Focused review periods before tests

---

## Installation & Setup

### Step 1: Copy Files to Your Computer

Download these files:
- `adp470s_learning_system.sh` - The interactive script
- `ADP470S_Study_Schedule_2026.md` - Your detailed study plan

### Step 2: Make Script Executable

Open your terminal and run:
```bash
chmod +x adp470s_learning_system.sh
```

### Step 3: Run the Script

```bash
./adp470s_learning_system.sh
```

Or if you get permission issues:
```bash
bash adp470s_learning_system.sh
```

---

## How to Use the Interactive Script

### Main Menu Features

When you run the script, you'll see:

```
╔══════════════════════════════════════════════════════════════╗
║  ADP470S: Data Structures & Algorithms Learning System  ║
╚══════════════════════════════════════════════════════════════╝

Select a term to study:

  1) Term 1: Algorithms & Complexity (10%)
Progress: [████████████░░░░░░░░░░░░░░░░░░░░░░░░░░░] 25% (2/8)

  2) Term 2: Stacks, Queues, Trees & Sorting (35%)
Progress: [░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░] 0% (0/14)

  3) Term 3: Graphs & Hashing (20% + Project)
Progress: [░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░] 0% (0/10)

  4) Term 4: Advanced Topics & Review (35%)
Progress: [░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░] 0% (0/7)

  5) View All Progress & Scores
  6) Reset All Progress
  0) Exit
```

### Tracking Your Learning

**To mark a week as complete:**
1. Select the term (1-4)
2. Select the week number
3. The checkbox will toggle ✓

**Example workflow:**
- Start Term 1 → Select option 1
- Complete Week 1 content → Mark week 1 as complete
- Take quiz → Select option 9, then enter week number
- Repeat for all weeks
- Take practice exam → Select the exam option

### Taking Quizzes

Each week has a quiz with 5 multiple-choice questions:
1. Enter the term menu
2. Select "Take Quiz on Current Topic"
3. Enter the week number
4. Answer questions (1, 2, or 3)
5. Get immediate feedback
6. See your score saved automatically

**Quiz Features:**
- Instant feedback on each answer
- Scores automatically saved with timestamp
- Can retake quizzes anytime
- Track improvement over time

### Progress Tracking

The script automatically:
- Saves your completion status
- Records quiz scores
- Shows progress bars for each term
- Maintains history of all attempts

**Data is stored in:**
- `~/.adp470s_progress.json` - Completion tracking
- `~/.adp470s_quiz_scores.json` - Quiz results

### Viewing Your Progress

Select option 5 from main menu to see:
- Overall progress for all terms
- Recent quiz scores
- Percentage completion
- Historical performance

---

## Study Schedule Guide

### How to Use the Study Schedule Document

The `ADP470S_Study_Schedule_2026.md` file contains:

**For Each Week:**
- Specific topics to cover
- Karumanchi textbook chapter references
- Weekly tasks checklist
- Self-study hour allocation
- Key concepts to master

**Study Approach:**

1. **Monday-Tuesday:** Read theory
   - Read assigned textbook chapters
   - Watch supplementary videos
   - Make notes

2. **Wednesday-Thursday:** Implementation
   - Code the algorithms
   - Test with different inputs
   - Debug and optimize

3. **Friday-Saturday:** Problem Solving
   - Solve practice problems
   - Work on exercises
   - Review challenging concepts

4. **Sunday:** Review & Planning
   - Review the week's learning
   - Take the weekly quiz
   - Plan next week
   - Mark progress in the script

### Important Dates to Note

- **Youth Day:** June 16 (Public Holiday)
- **Term 1 Test:** End of March (~10%)
- **Term 2 Test:** Mid-July (~35%) ⭐ MAJOR
- **Term 3 Project:** Early September
- **Term 3 Test:** Late September (~20%)
- **Term 4 Test:** Late October (~35%) ⭐ MAJOR

---

## Weekly Study Routine

### Recommended Daily Schedule

**Weekdays (Monday-Friday):** 4 hours/day
- Morning (1 hour): Read theory
- Afternoon (2 hours): Code implementation
- Evening (1 hour): Problem solving

**Weekends:** 6 hours/day
- Saturday: Practice and exercises
- Sunday: Review and quiz

**Total:** ~32 hours/week
- Contact time: ~3 hours
- Self-study: ~29 hours

### Study Techniques

**Active Learning:**
- Don't just read - implement every algorithm
- Draw diagrams for data structures
- Explain concepts out loud
- Teach others

**Code Practice:**
- Type code manually (don't copy-paste)
- Test with edge cases
- Analyze time complexity
- Compare implementations

**Problem Solving:**
- Understand the problem fully first
- Think before coding
- Test thoroughly
- Learn from mistakes

---

## Textbook Navigation

### Karumanchi Book Structure

The book "Data Structures and Algorithms Made Easy in Java" is organized as:

**Key Chapters:**
1. Introduction - Algorithm basics
2. Recursion & Backtracking - Recursive solutions
3. Linked Lists - All list types
4. Stacks - Stack implementations
5. Queues - Queue variations
6. Trees - Binary trees, BST, AVL, Heaps
7. Priority Queues & Heaps
8. Disjoint Sets
9. Graphs - Representations, traversals, algorithms
10. Sorting - All sorting algorithms
11. Searching - Search techniques
12. Hashing - Hash tables

**How to Read:**
1. Read the concept explanation
2. Study the example problems
3. Trace through the algorithms
4. Implement the code
5. Solve the exercises

---

## Tips for Success

### Do's ✅

1. **Attend ALL classes** - Compulsory
2. **Start assignments early** - No late submissions
3. **Practice coding daily** - Build muscle memory
4. **Ask questions immediately** - Don't let doubts pile up
5. **Test thoroughly** - Quality over quantity
6. **Join study groups** - Learn together
7. **Track your progress** - Use the script
8. **Review regularly** - Avoid cramming

### Don'ts ❌

1. **Don't skip classes** - You'll miss crucial explanations
2. **Don't procrastinate** - Deadlines are strict
3. **Don't just read** - You must code
4. **Don't memorize** - Understand the concepts
5. **Don't copy code** - Plagiarism is serious
6. **Don't ignore weak areas** - Address them early
7. **Don't cram before tests** - Study consistently
8. **Don't work in isolation** - Collaborate appropriately

### Time Management

**High Priority Tasks:**
- Attend lectures
- Complete assignments
- Prepare for major tests (T2 35%, T4 35%)

**Medium Priority:**
- Weekly quizzes
- Practice problems
- Study group sessions

**Ongoing:**
- Daily code practice
- Textbook reading
- Progress tracking

---

## Assessment Strategy

### Test Preparation Timeline

**2 Weeks Before:**
- Complete all weekly topics
- Finish all exercises
- Review notes

**1 Week Before:**
- Take practice exams
- Identify weak areas
- Intensive review

**3 Days Before:**
- Light review only
- Practice writing code on paper
- Rest well

**Day Before:**
- Quick review of key concepts
- Prepare materials
- Relax

### During the Test

1. **Read ALL questions first**
2. **Answer easy questions first**
3. **Manage your time** (time per question)
4. **Show your work** (partial credit possible)
5. **Check your answers** (if time permits)

### After the Test

1. **Note difficult questions** for future study
2. **Raise queries within 1 week**
3. **Learn from mistakes**
4. **Move forward positively**

---

## Getting Help

### When You're Stuck

**Order of Escalation:**
1. Check textbook and notes
2. Search online (VisuAlgo, GeeksforGeeks)
3. Ask study group
4. Post on class forum/WhatsApp
5. Email lecturer: makhuranet@cput.ac.za
6. Attend office hours
7. Use CRIMS system (for formal issues)

### Resources

**Primary:**
- Karumanchi textbook
- Class notes
- Blackboard materials

**Secondary:**
- VisuAlgo.net - Visualizations
- GeeksforGeeks - Explanations
- LeetCode - Practice problems
- YouTube - Tutorial videos

**Support:**
- Lecturer office hours
- Study groups
- Course mates
- Online forums

---

## Frequently Asked Questions

**Q: Can I use the script on Windows?**
A: Yes, but you'll need:
- Git Bash, OR
- WSL (Windows Subsystem for Linux), OR
- Cygwin
Python 3 is also required.

**Q: What if I miss a class?**
A: Get notes from classmates, review Blackboard materials, and catch up ASAP. Remember: attendance is compulsory.

**Q: Can I submit assignments late?**
A: No. The course policy is clear: NO late submissions.

**Q: What if I'm sick during a test?**
A: Submit a medical certificate within one week and notify the lecturer on the test day. You can write during "sick test week" in Term 4.

**Q: How many hours should I study per week?**
A: Minimum 30 hours total:
- 3 hours class time
- 27 hours self-study and practice

**Q: Which language should I use?**
A: Primary: Java. Alternatives: Python or C#. Stick to one language throughout.

**Q: Can I work with classmates?**
A: Yes for learning and study groups. No for copying assignments. Understand the difference.

**Q: What's the pass mark?**
A: Check CPUT regulations. Typically 50% overall, but verify with your lecturer.

---

## Script Customization

### Adding More Quizzes

The script is designed for expansion. To add more quiz questions:

1. Open `adp470s_learning_system.sh`
2. Find the quiz function (e.g., `take_term2_quiz`)
3. Add more week cases following the pattern
4. Save and run

### Modifying Progress Tracking

To add custom tracking:
1. Edit the JSON structure in `initialize_data()`
2. Add new fields as needed
3. Update display functions

---

## Troubleshooting

### Common Issues

**Script won't run:**
```bash
# Make it executable
chmod +x adp470s_learning_system.sh

# Or run with bash
bash adp470s_learning_system.sh
```

**"Command not found":**
```bash
# Make sure you're in the right directory
ls -la

# Check if file exists
cat adp470s_learning_system.sh
```

**Progress not saving:**
```bash
# Check if Python 3 is installed
python3 --version

# Check permissions
ls -la ~/.adp470s_progress.json
```

**Weird characters displayed:**
```bash
# Your terminal may not support colors
# Edit the script and remove color codes if needed
```

---

## Final Advice

### Success Mindset

1. **Be Patient:** DSA is challenging but rewarding
2. **Practice Daily:** Consistency beats cramming
3. **Embrace Mistakes:** They're learning opportunities
4. **Stay Curious:** Explore beyond requirements
5. **Help Others:** Teaching reinforces learning
6. **Celebrate Progress:** Acknowledge your achievements
7. **Stay Healthy:** Sleep, exercise, eat well
8. **Believe in Yourself:** You can master this!

### The Journey

This is an 11-month journey. You'll face challenges:
- Complex algorithms that seem impossible
- Debugging sessions that take hours
- Topics that don't click immediately

But you'll also experience:
- "Aha!" moments when concepts click
- Satisfaction of working code
- Confidence in problem-solving
- Skills that last a lifetime

**Remember:** Every expert was once a beginner. Every successful student felt overwhelmed at times. The difference is they persisted.

---

## Checklist Before Starting

- [ ] Script downloaded and working
- [ ] Study schedule reviewed
- [ ] Textbook acquired
- [ ] Study space organized
- [ ] Study groups formed
- [ ] Blackboard access confirmed
- [ ] Calendar marked with important dates
- [ ] Commitment made to consistent study
- [ ] Goals set for each term
- [ ] Excited to learn!

---

**You're ready! Let's master Data Structures and Algorithms!** 🚀

**Next Steps:**
1. Run the script: `./adp470s_learning_system.sh`
2. Start Term 1, Week 1
3. Read the study schedule for this week
4. Begin your first study session
5. Track your progress

**Good luck!** 💪📚

---

*If you have questions about using this system, contact your lecturer or post in the class forum.*

**Created:** February 2026  
**For:** ADP470S Students  
**Purpose:** Your success in Data Structures & Algorithms
