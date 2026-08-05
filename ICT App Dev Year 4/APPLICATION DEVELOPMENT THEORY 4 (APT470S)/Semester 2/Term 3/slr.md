# AI-Driven Model Engineering SLR — Project Charter & Work Breakdown Structure (WBS)

## 7-Person Team | APT470S | Submission: 27 August 2026


---

# PART A: PROJECT CHARTER

---

## 1. Executive Summary

| **Project Title** | AI-Driven Model Engineering: A Systematic Literature Review of Intelligent Model Generation, Transformation, Validation, and Software Synthesis |
|---|---|
| **Course** | APT470S — Applications Development Theory 4 |
| **Term** | Term 3, 2026 |
| **Submission Deadline** | Close of Business (CoB), 27 August 2026 |
| **Team Size** | 7 members |
| **Project Type** | Systematic Literature Review (SLR) |
| **Primary Framework** | PRISMA 2020 + Kitchenham SE SLR Guidelines |

This charter establishes the governance structure, roles, responsibilities, timelines, and quality assurance mechanisms for the systematic literature review project. The project aims to systematically identify, classify, and critically evaluate the application of artificial intelligence across the model-engineering lifecycle, producing a multidimensional taxonomy, maturity model, reference architecture, and future research agenda for AI-Driven Model Engineering (AI-DME).

---

## 2. Project Background & Research Motivation

Model-Driven Engineering (MDE) places models at the centre of software development, representing system perspectives including context, interactions, structure, and behaviour. Traditional MDE transforms Computation-Independent Models through Platform-Independent Models to Platform-Specific Models and finally to executable software. Despite its potential to improve abstraction, reuse, productivity, and platform independence, conventional MDE remains constrained by specialist skill requirements, tool complexity, rigid transformation rules, model-code inconsistencies, and the difficulty of maintaining models as systems and requirements evolve.

Artificial Intelligence — including large language models, machine learning, deep learning, multimodal foundation models, knowledge graphs, neuro-symbolic methods, and intelligent agents — creates opportunities to automate and augment model-engineering activities. The emerging research challenge is no longer limited to generating individual UML diagrams; it concerns how AI can support the complete, continuous, and trustworthy engineering of software models.

**AI-Driven Model Engineering (AI-DME)** is defined as the systematic application of artificial intelligence to generate, interpret, complete, transform, validate, optimise, synchronise, explain, and evolve software models throughout the software-development lifecycle.

---

## 3. Research Aim & Questions

### 3.1 Primary Research Aim

To systematically identify, classify, and critically evaluate the application of artificial intelligence across the model-engineering lifecycle and to develop an evidence-based taxonomy, maturity model, reference architecture, and future research agenda for AI-Driven Model Engineering.

### 3.2 Main Research Question

**How is artificial intelligence transforming the generation, analysis, validation, transformation, and evolution of software models across the model-engineering lifecycle?**

### 3.3 Sub-Research Questions (Mapped to Team Members)

| **RQ** | **Category** | **Question** | **Lead** |
|---|---|---|---|
| RQ1 | Landscape | What publication trends, research communities, application domains, and contribution types characterise AI-DME research? | P1 |
| RQ2 | Technologies | Which AI technologies are used (LLMs, ML, DL, multimodal, knowledge graphs, RL, neuro-symbolic, agents)? | P2 |
| RQ3 | Lifecycle | At which stages of the model-engineering lifecycle is AI applied? | P3 |
| RQ4 | Languages | Which modelling languages and artefacts are supported (UML, SysML, BPMN, DSLs, metamodels)? | P3 |
| RQ5 | Requirements | How is AI used to transform natural-language/multimodal requirements into models? | P4 |
| RQ6 | Roles | What roles does AI perform (generator, recommender, critic, validator, transformer, repair, agent)? | P4 |
| RQ7 | Automation | What levels of automation are achieved (assistance → semi-autonomous → continuous autonomous)? | P5 |
| RQ8 | Evaluation | How are AI-generated models evaluated (syntactic, semantic, completeness, consistency, traceability)? | P5 |
| RQ9 | Validation | Which deterministic tools validate AI outputs (metamodels, OCL, checkers, simulators, human review)? | P6 |
| RQ10 | Transformation | How does AI support model-to-model, model-to-text, model-to-code, and code-to-model transformations? | P6 |
| RQ11 | Improvement | To what extent do AI-driven approaches improve productivity, quality, and adaptability vs traditional MDE? | P1 |
| RQ12 | Risks | What risks arise from hallucination, nondeterminism, drift, privacy, IP, and automation bias? | P7 |
| RQ13 | Adoption | What factors influence industrial adoption, interoperability, scalability, and readiness? | P7 |
| RQ14 | Evidence | What evidence exists regarding reproducibility, generalisability, and real-world deployment? | P1 |
| RQ15 | Contribution | What taxonomy, maturity model, evaluation hierarchy, and reference architecture can guide AI-DME? | **All** |

---

## 4. Scope Definition

### 4.1 Inclusion Scope

The review covers the **complete model-engineering lifecycle** rather than restricting analysis to automated UML generation:

| **AI-DME Area** | **Representative Activities** |
|---|---|
| Requirements understanding | Extract actors, entities, constraints, relationships, behaviours, ambiguities, quality defects |
| Requirements-to-model generation | Produce use-case, class, sequence, activity, state, architecture, and domain models |
| Model completion | Recommend missing classes, attributes, relationships, states, transitions, or constraints |
| Model quality assurance | Detect incorrect, incomplete, inconsistent, ambiguous, or non-conforming models |
| Model repair | Correct structural, syntactic, semantic, and cross-view defects |
| Model transformation | Generate or refine model-to-model transformation rules |
| Model-to-code synthesis | Produce executable code, tests, configurations, and deployment artefacts |
| Code-to-model extraction | Recover architecture, UML views, and domain abstractions from repositories |
| Model-code synchronisation | Maintain consistency among requirements, models, implementations, and tests |
| Model evolution | Update models as requirements, technologies, and environments change |
| Runtime modelling | Update models using telemetry, logs, execution traces, and digital twins |
| Self-adaptive systems | Use runtime models and AI to recommend or execute software reconfiguration |
| Collaborative modelling | Support communication and joint decision-making among stakeholders |

### 4.2 Exclusion Boundaries

| **Include** | **Exclude** |
|---|---|
| Apply identifiable AI technique to model-engineering task | Discuss AI or MDE only conceptually without technical contribution |
| Address software or systems modelling | Use "model" only to mean predictive machine-learning model |
| Generate, analyse, validate, transform, repair, synchronise, or evolve models | Generate code directly without using or producing a software model |
| Present framework, method, algorithm, tool, dataset, or empirical evaluation | Address non-software CAD models outside systems engineering |
| Provide sufficient technical/methodological information | Are editorials, abstracts, posters, or tutorials without full results |
| Peer-reviewed within selected period | Duplicate a later or extended version of the same study |

---

## 5. Team Structure & Role Assignment

### 5.1 Core Team Roles

| **Role** | **Person** | **Primary Responsibilities** |
|---|---|---|
| **Project Lead & Synthesis Coordinator** | P1 | Overall coordination, final synthesis, taxonomy development, RQ1/RQ11/RQ14 leadership, quality assurance |
| **Search Strategy & Protocol Lead** | P2 | Search string development, database configuration, protocol documentation, RQ2 leadership |
| **Screening Coordinator** | P3 | Title/abstract screening oversight, duplicate management, RQ3/RQ4 leadership |
| **Data Extraction Coordinator** | P4 | Extraction framework pilot, coding consistency, RQ5/RQ6 leadership |
| **Quality Assessment Lead** | P5 | Quality appraisal instrument, scoring coordination, RQ7/RQ8 leadership |
| **Evidence Synthesis Lead** | P6 | Thematic/comparative synthesis coordination, RQ9/RQ10 leadership |
| **Governance & Risk Lead** | P7 | Risk assessment, adoption analysis, reproducibility, RQ12/RQ13 leadership |

### 5.2 Database Assignments (Primary Search)

| **Person** | **Primary Database** | **Estimated Records** |
|---|---|---|
| P1 | IEEE Xplore | ~318 |
| P2 | ACM Digital Library | ~178 |
| P3 | ScienceDirect | ~252 |
| P4 | SpringerLink | ~211 |
| P5 | Scopus | ~140 |
| P6 | Web of Science | ~60 (after deduplication) |
| P7 | **Google Scholar Snowballing** (backward + forward citation) + floating support | Variable |

**Note:** P7 has no primary database in Week 1. They assist two other members to clear search results faster, then switch fully to snowballing once the team has a first-draft Include list (typically partway through Weeks 1-2).

---

## 6. Quality Assurance Framework

### 6.1 Quality Assessment Criteria (18-item Checklist)

Each item scored 0 = No, 0.5 = Partial, 1 = Yes:

| **#** | **Criterion** | **Quality Question** |
|---|---|---|
| 1 | Research clarity | Are the aim and research problems clearly stated? |
| 2 | Context | Is the software and modelling context adequately described? |
| 3 | AI transparency | Are the AI model, version, configuration, prompts, and adaptation strategy reported? |
| 4 | Modelling transparency | Are the modelling language, metamodel, and artefacts identified? |
| 5 | Dataset quality | Are the dataset origin, composition, and preparation described? |
| 6 | Baseline | Is there an appropriate human, rule-based, or non-AI baseline? |
| 7 | Syntactic validity | Is grammar or metamodel conformance evaluated? |
| 8 | Semantic fidelity | Is alignment with source requirements or system meaning assessed? |
| 9 | Completeness | Are omitted entities, relationships, behaviours, or constraints measured? |
| 10 | Cross-view consistency | Are relationships among multiple model views evaluated? |
| 11 | Independent validation | Is validation performed independently of the development team? |
| 12 | Human expertise | Is human expert judgement incorporated? |
| 13 | Experimental rigour | Are experiments designed with appropriate controls? |
| 14 | Statistical analysis | Are appropriate statistical methods applied? |
| 15 | Reproducibility | Are replication assets (code, data, prompts) available? |
| 16 | Practical relevance | Is the work applicable to real-world development contexts? |
| 17 | Scalability | Is scalability to larger/industrial systems addressed? |
| 18 | Threats to validity | Are threats to validity identified and mitigated? |

### 6.2 Maturity Level Assignment (1-6)

| **Level** | **Description** |
|---|---|
| 1 — Manual modelling | No substantive AI support |
| 2 — Assistive modelling | AI provides explanations, recommendations, and local improvements |
| 3 — Interactive co-modelling | Human and AI iteratively construct and refine models |
| 4 — Semi-autonomous modelling | AI generates substantial models/transformations requiring human approval |
| 5 — Verifier-guided autonomous modelling | AI generates, validates, diagnoses, and repairs models using deterministic feedback |
| 6 — Continuous adaptive modelling | AI agents maintain requirements-model-code-runtime alignment and support autonomous evolution |

---

## 7. Key Deliverables

| **Deliverable** | **Description** | **Lead** | **Due** |
|---|---|---|---|
| SLR Protocol | Registered protocol with search strings, criteria, and procedures | P2 | Week 1 |
| PRISMA Flow Diagram | Complete flow diagram with all counts | P3 | Week 3 |
| Screening Tracker | Completed title/abstract screening log | All | Week 2 |
| Full-Text Eligibility | Completed full-text review with exclusion reasons | All | Week 3 |
| Data Extraction | Completed extraction for all included papers | All | Week 4 |
| Quality Assessment | Completed scoring for all included papers | All | Week 4 |
| Draft Manuscript | Full SLR manuscript (20-30 pages) | All | Week 5 |
| Final Manuscript | Polished submission-ready manuscript | All | Week 6 |
| Presentation Slides | Professional oral presentation | All | Week 6 |
| Evidence Repository | Openly available replication package | P7 | Week 6 |

---

# PART B: WORK BREAKDOWN STRUCTURE (WBS)

---

## 8. WBS Overview — 6 Phases

```
┌─────────────────────────────────────────────────────────────────────────────────────┐
│                     AI-DME SLR — WORK BREAKDOWN STRUCTURE (7-Person Team)           │
├─────────────────────────────────────────────────────────────────────────────────────┤
│                                                                                     │
│  ┌──────────────┐    ┌──────────────┐    ┌──────────────┐    ┌──────────────┐      │
│  │   PHASE 1    │    │   PHASE 2    │    │   PHASE 3    │    │   PHASE 4    │      │
│  │  Protocol &  │───▶│  Search &    │───▶│  Screening   │───▶│  Full-Text   │      │
│  │  Planning    │    │  Retrieval   │    │  (Title/Abs) │    │  Eligibility │      │
│  └──────────────┘    └──────────────┘    └──────────────┘    └──────────────┘      │
│         │                   │                   │                   │              │
│         ▼                   ▼                   ▼                   ▼              │
│  ┌──────────────┐    ┌──────────────┐    ┌──────────────┐    ┌──────────────┐      │
│  │   PHASE 5    │    │   PHASE 6    │    │   PHASE 7    │    │   PHASE 8    │      │
│  │  Data        │───▶│  Quality     │───▶│  Evidence    │───▶│  Manuscript  │      │
│  │  Extraction  │    │  Assessment  │    │  Synthesis   │    │  & Final     │      │
│  └──────────────┘    └──────────────┘    └──────────────┘    └──────────────┘      │
│                                                                                     │
└─────────────────────────────────────────────────────────────────────────────────────┘
```

---

## 9. Detailed WBS by Phase

### PHASE 1: Protocol Development & Planning (Week 1 — 5 days)

| **Task ID** | **Task** | **Description** | **Assignee** | **Hours** | **Dependencies** |
|---|---|---|---|---|---|
| 1.1 | Kick-off meeting | Team orientation, role assignment, timeline review | All | 1.5 | — |
| 1.2 | Protocol drafting | Develop SLR protocol per Kitchenham guidelines | P2 | 4 | 1.1 |
| 1.3 | Research question refinement | Finalise RQs and mapping to team members | P1 | 2 | 1.1 |
| 1.4 | Search string development | Create database-adapted search strings with keywords/synonyms | P2 | 3 | 1.2 |
| 1.5 | Inclusion/exclusion criteria | Define and pilot-test criteria on 5 sample papers | All | 2 | 1.2 |
| 1.6 | Data extraction pilot | Pilot extraction on 2 shared papers to ensure consistency | P4 | 3 | 1.5 |
| 1.7 | Quality assessment calibration | Calibrate scoring on 2 pilot papers | P5 | 2 | 1.5 |
| 1.8 | Protocol registration | Finalise and register/publish protocol | P2 | 1 | 1.2-1.7 |
| 1.9 | Team training | Training on tools (Excel, reference managers, screening) | P3 | 1.5 | 1.1 |

**Phase 1 Total Hours: 20** | **Per Person Average: ~2.9 hrs**

---

### PHASE 2: Search & Retrieval (Week 1-2 — 7 days)

| **Task ID** | **Task** | **Description** | **Assignee** | **Hours** | **Dependencies** |
|---|---|---|---|---|---|
| 2.1 | Database search — IEEE Xplore | Execute search, export results (~318 records) | P1 | 4 | 1.8 |
| 2.2 | Database search — ACM DL | Execute search, export results (~178 records) | P2 | 3 | 1.8 |
| 2.3 | Database search — ScienceDirect | Execute search, export results (~252 records) | P3 | 4 | 1.8 |
| 2.4 | Database search — SpringerLink | Execute search, export results (~211 records) | P4 | 3.5 | 1.8 |
| 2.5 | Database search — Scopus | Execute search, export results (~140 records) | P5 | 2.5 | 1.8 |
| 2.6 | Database search — Web of Science | Execute search, export results (~60 records after dedup) | P6 | 1.5 | 1.8 |
| 2.7 | Snowballing preparation | Identify key papers for backward/forward citation search | P7 | 3 | 2.1-2.6 |
| 2.8 | Deduplication | Remove duplicate records across all databases | P3 | 3 | 2.1-2.7 |
| 2.9 | Record consolidation | Consolidate all records into master screening log | P3 | 2 | 2.8 |

**Phase 2 Total Hours: 26.5** | **Per Person Average: ~3.8 hrs**

---

### PHASE 3: Title/Abstract Screening (Week 2-3 — 7 days)

**Screening Protocol:** Each paper screened by 2 people independently; disagreements resolved through consensus or third reviewer.

| **Task ID** | **Task** | **Description** | **Assignee** | **Hours** | **Dependencies** |
|---|---|---|---|---|---|
| 3.1 | Screening batch assignment | Divide ~1,159 records into balanced batches | P3 | 1 | 2.9 |
| 3.2 | Screening — Batch A (~193 papers) | Title/abstract screening as Reviewer 1 | P1 | 6 | 3.1 |
| 3.3 | Screening — Batch B (~193 papers) | Title/abstract screening as Reviewer 1 | P2 | 6 | 3.1 |
| 3.4 | Screening — Batch C (~193 papers) | Title/abstract screening as Reviewer 1 | P3 | 6 | 3.1 |
| 3.5 | Screening — Batch D (~193 papers) | Title/abstract screening as Reviewer 1 | P4 | 6 | 3.1 |
| 3.6 | Screening — Batch E (~193 papers) | Title/abstract screening as Reviewer 1 | P5 | 6 | 3.1 |
| 3.7 | Screening — Batch F (~194 papers) | Title/abstract screening as Reviewer 1 | P6 | 6 | 3.1 |
| 3.8 | Second reviewer screening | Each person screens as Reviewer 2 for another's batch | All | 6 | 3.2-3.7 |
| 3.9 | Disagreement resolution | Resolve conflicts between Reviewer 1 & 2 decisions | P3 + All | 3 | 3.2-3.8 |
| 3.10 | Snowballing screening | Screen papers from citation snowballing | P7 | 4 | 3.9 |

**Phase 3 Total Hours: 50** | **Per Person Average: ~7.1 hrs**

**Screening Batch Distribution:**

| **Batch** | **Reviewer 1** | **Reviewer 2** | **# Papers** |
|---|---|---|---|
| A | P1 | P2 | ~193 |
| B | P2 | P3 | ~193 |
| C | P3 | P4 | ~193 |
| D | P4 | P5 | ~193 |
| E | P5 | P6 | ~193 |
| F | P6 | P1 | ~194 |

---

### PHASE 4: Full-Text Eligibility (Week 3-4 — 7 days)

| **Task ID** | **Task** | **Description** | **Assignee** | **Hours** | **Dependencies** |
|---|---|---|---|---|---|
| 4.1 | Full-text retrieval | Obtain full texts for all included/maybe papers (~242 papers) | All | 4 | 3.10 |
| 4.2 | Full-text review — Batch 1 (~40 papers) | Read full text, apply eligibility criteria | P1 | 8 | 4.1 |
| 4.3 | Full-text review — Batch 2 (~40 papers) | Read full text, apply eligibility criteria | P2 | 8 | 4.1 |
| 4.4 | Full-text review — Batch 3 (~40 papers) | Read full text, apply eligibility criteria | P3 | 8 | 4.1 |
| 4.5 | Full-text review — Batch 4 (~40 papers) | Read full text, apply eligibility criteria | P4 | 8 | 4.1 |
| 4.6 | Full-text review — Batch 5 (~40 papers) | Read full text, apply eligibility criteria | P5 | 8 | 4.1 |
| 4.7 | Full-text review — Batch 6 (~42 papers) | Read full text, apply eligibility criteria | P6 | 8.5 | 4.1 |
| 4.8 | Snowballing full-text | Full-text review of snowballed papers | P7 | 8 | 4.1 |
| 4.9 | Exclusion reason documentation | Document reasons for every excluded paper | All | 2 | 4.2-4.8 |
| 4.10 | Final inclusion count | Confirm final included set (~86 papers) | P3 | 1 | 4.9 |

**Phase 4 Total Hours: 63.5** | **Per Person Average: ~9.1 hrs**

---

### PHASE 5: Data Extraction (Week 4-5 — 7 days)

**Extraction Fields (28 fields per paper)**:

| **Category** | **Fields** |
|---|---|
| **Bibliographic** | Title, Authors, Year, Venue, Country/Institution |
| **Study Type** | Study/Contribution Type, Application Domain, System Scale |
| **AI** | AI Technique/Model/Version, Prompting/Training/Adaptation, Agent Design |
| **Modelling** | Model-Engineering Stage/Task, Modelling Language/Metamodel/Diagram, Input/Output Artefacts |
| **Evaluation** | Dataset/Benchmark, Baseline/Comparison, Validation Mechanism, Human Involvement |
| **Performance** | Quality Metrics, Computational Cost/Scalability, Explainability/Uncertainty |
| **Quality** | Standards Conformance/Traceability, Reproducibility Assets |
| **Synthesis** | Reported Benefits, Limitations, Industrial Evidence, Maturity Level |

| **Task ID** | **Task** | **Description** | **Assignee** | **Hours** | **Dependencies** |
|---|---|---|---|---|---|
| 5.1 | Extraction batch assignment | Divide ~86 final papers into 7 balanced batches | P4 | 1 | 4.10 |
| 5.2 | Extraction — Batch 1 (~12 papers) | Extract all 28 fields for each paper | P1 | 12 | 5.1 |
| 5.3 | Extraction — Batch 2 (~12 papers) | Extract all 28 fields for each paper | P2 | 12 | 5.1 |
| 5.4 | Extraction — Batch 3 (~12 papers) | Extract all 28 fields for each paper | P3 | 12 | 5.1 |
| 5.5 | Extraction — Batch 4 (~12 papers) | Extract all 28 fields for each paper | P4 | 12 | 5.1 |
| 5.6 | Extraction — Batch 5 (~12 papers) | Extract all 28 fields for each paper | P5 | 12 | 5.1 |
| 5.7 | Extraction — Batch 6 (~13 papers) | Extract all 28 fields for each paper | P6 | 13 | 5.1 |
| 5.8 | Extraction — Batch 7 (~13 papers) | Extract all 28 fields for each paper | P7 | 13 | 5.1 |
| 5.9 | Extraction cross-check | Peer-review extraction quality for 2 papers each | All | 3 | 5.2-5.8 |
| 5.10 | Extraction consolidation | Consolidate all extraction data | P4 | 2 | 5.9 |

**Phase 5 Total Hours: 92** | **Per Person Average: ~13.1 hrs**

---

### PHASE 6: Quality Assessment (Week 5 — 5 days)

| **Task ID** | **Task** | **Description** | **Assignee** | **Hours** | **Dependencies** |
|---|---|---|---|---|---|
| 6.1 | QA batch assignment | Divide ~86 papers into 7 balanced batches | P5 | 1 | 5.10 |
| 6.2 | Quality assessment — Batch 1 (~12 papers) | Score 18 criteria (0/0.5/1) | P1 | 6 | 6.1 |
| 6.3 | Quality assessment — Batch 2 (~12 papers) | Score 18 criteria (0/0.5/1) | P2 | 6 | 6.1 |
| 6.4 | Quality assessment — Batch 3 (~12 papers) | Score 18 criteria (0/0.5/1) | P3 | 6 | 6.1 |
| 6.5 | Quality assessment — Batch 4 (~12 papers) | Score 18 criteria (0/0.5/1) | P4 | 6 | 6.1 |
| 6.6 | Quality assessment — Batch 5 (~12 papers) | Score 18 criteria (0/0.5/1) | P5 | 6 | 6.1 |
| 6.7 | Quality assessment — Batch 6 (~13 papers) | Score 18 criteria (0/0.5/1) | P6 | 6.5 | 6.1 |
| 6.8 | Quality assessment — Batch 7 (~13 papers) | Score 18 criteria (0/0.5/1) | P7 | 6.5 | 6.1 |
| 6.9 | QA cross-check | Pair up and cross-check scoring for 3 papers each | All | 3 | 6.2-6.8 |
| 6.10 | QA consolidation | Consolidate scores and evidence weighting | P5 | 2 | 6.9 |

**Phase 6 Total Hours: 49** | **Per Person Average: ~7.0 hrs**

---

### PHASE 7: Evidence Synthesis (Week 5-6 — 7 days)

| **Task ID** | **Task** | **Description** | **Assignee** | **Hours** | **Dependencies** |
|---|---|---|---|---|---|
| 7.1 | Descriptive analysis | Publication trends, venues, countries, technologies, languages | P1 | 8 | 6.10 |
| 7.2 | Thematic synthesis — Requirements | Requirements-to-model generation synthesis | P2 | 6 | 6.10 |
| 7.3 | Thematic synthesis — Quality | Semantic quality, validation, repair synthesis | P3 | 6 | 6.10 |
| 7.4 | Thematic synthesis — Transformation | Intelligent transformation, code generation synthesis | P4 | 6 | 6.10 |
| 7.5 | Thematic synthesis — Evolution | Runtime models, synchronisation, adaptation synthesis | P5 | 6 | 6.10 |
| 7.6 | Comparative synthesis | AI vs human, LLM-only vs verifier-guided, etc. | P6 | 8 | 6.10 |
| 7.7 | Taxonomy development | Multidimensional taxonomy (7 dimensions) | All | 6 | 7.1-7.6 |
| 7.8 | Maturity model development | 6-level AI-DME maturity model | All | 4 | 7.7 |
| 7.9 | Reference architecture | Verifier-guided reference architecture | All | 4 | 7.8 |
| 7.10 | Gap analysis | Identify under-researched areas and research agenda | P7 | 6 | 7.1-7.6 |
| 7.11 | Synthesis consolidation | Integrate all synthesis components | P1 | 4 | 7.1-7.10 |

**Phase 7 Total Hours: 64** | **Per Person Average: ~9.1 hrs**

---

### PHASE 8: Manuscript Writing & Finalisation (Week 6 — 7 days)

| **Task ID** | **Task** | **Description** | **Assignee** | **Hours** | **Dependencies** |
|---|---|---|---|---|---|
| 8.1 | Introduction & Background | Write Sections 1-2 (Background, Motivation, Definition) | P1 | 6 | 7.11 |
| 8.2 | Methodology section | Write Section 5 (Protocol, Search, Selection, QA) | P2 | 6 | 7.11 |
| 8.3 | Results — Descriptive | Write descriptive analysis results | P1 | 6 | 7.1 |
| 8.4 | Results — Thematic | Write thematic synthesis results | P2-P5 | 8 | 7.2-7.5 |
| 8.5 | Results — Comparative | Write comparative synthesis results | P6 | 6 | 7.6 |
| 8.6 | Discussion | Write discussion, implications, limitations | P7 | 6 | 7.11 |
| 8.7 | Taxonomy & Maturity Model | Write Section 4 (Taxonomy, Maturity Model) | All | 6 | 7.7-7.8 |
| 8.8 | Reference Architecture | Write reference architecture section | All | 4 | 7.9 |
| 8.9 | Research Agenda | Write future research agenda | All | 4 | 7.10 |
| 8.10 | Conclusion | Write conclusion | P1 | 3 | 8.1-8.9 |
| 8.11 | Abstract & Title | Write structured abstract (PRISMA abstract checklist) | P1 | 2 | 8.10 |
| 8.12 | PRISMA Flow Diagram | Create PRISMA 2020 flow diagram | P3 | 3 | 4.10 |
| 8.13 | Figures & Tables | Create all figures and tables with titles/sources | All | 4 | 8.1-8.12 |
| 8.14 | References | Format references (APA 7th Edition) | P2 | 4 | 8.1-8.13 |
| 8.15 | First draft integration | Integrate all sections into complete draft | P1 | 4 | 8.1-8.14 |
| 8.16 | Team review & feedback | Full team review of complete draft | All | 4 | 8.15 |
| 8.17 | Revision & polishing | Address feedback, polish language, check formatting | All | 6 | 8.16 |
| 8.18 | Final submission package | Prepare final manuscript (20-30 pages) + appendices | P1 | 3 | 8.17 |
| 8.19 | Presentation slides | Create oral presentation slides | All | 6 | 8.18 |

**Phase 8 Total Hours: 91** | **Per Person Average: ~13.0 hrs**

---

## 10. Master Timeline (Gantt View)

| **Phase** | **Week 1** | **Week 2** | **Week 3** | **Week 4** | **Week 5** | **Week 6** |
|---|---|---|---|---|---|---|
| **Phase 1: Protocol** | ██████████ | | | | | |
| **Phase 2: Search** | ████ | ██████ | | | | |
| **Phase 3: Screening** | | ████ | ██████ | | | |
| **Phase 4: Full-Text** | | | ████ | ██████ | | |
| **Phase 5: Extraction** | | | | ████ | ██████ | |
| **Phase 6: Quality** | | | | | ██████ | |
| **Phase 7: Synthesis** | | | | | ████ | ██████ |
| **Phase 8: Writing** | | | | | ████ | ██████████ |

```
Key Milestones:
M1: Protocol Registered — End Week 1
M2: Search Complete — Mid Week 2
M3: Screening Complete — End Week 3
M4: Full-Text Complete — Mid Week 4
M5: Extraction Complete — End Week 5
M6: QA Complete — End Week 5
M7: Synthesis Complete — Mid Week 6
M8: Final Submission — CoB 27 August 2026
```

---

## 11. Workload Balance Summary

| **Person** | **Phase 1** | **Phase 2** | **Phase 3** | **Phase 4** | **Phase 5** | **Phase 6** | **Phase 7** | **Phase 8** | **TOTAL** |
|---|---|---|---|---|---|---|---|---|---|
| **P1** | 3.5 | 4.0 | 7.0 | 9.0 | 13.0 | 7.0 | 10.0 | 14.0 | **67.5** |
| **P2** | 4.5 | 3.0 | 7.0 | 9.0 | 13.0 | 7.0 | 8.0 | 14.0 | **65.5** |
| **P3** | 3.0 | 5.0 | 8.0 | 9.0 | 13.0 | 7.0 | 8.0 | 13.0 | **66.0** |
| **P4** | 3.0 | 3.5 | 7.0 | 9.0 | 13.0 | 7.0 | 8.0 | 13.0 | **63.5** |
| **P5** | 2.5 | 2.5 | 7.0 | 9.0 | 13.0 | 8.0 | 8.0 | 13.0 | **63.0** |
| **P6** | 1.5 | 1.5 | 7.0 | 9.5 | 13.0 | 7.5 | 10.0 | 13.0 | **63.0** |
| **P7** | 2.0 | 7.0 | 7.0 | 9.0 | 14.0 | 7.5 | 12.0 | 11.0 | **69.5** |
| **TEAM** | **20.0** | **26.5** | **50.0** | **63.5** | **92.0** | **51.0** | **64.0** | **91.0** | **458.0** |

**Average per person: ~65.4 hours** | **Variance: ±3.2 hours**

---

## 12. PRISMA 2020 Flow Diagram Template

```
PRISMA 2020 Flow Diagram — AI-DME SLR

┌─────────────────────────────────────────────────────────────────────────────────┐
│                           IDENTIFICATION                                      │
├─────────────────────────────────────────────────────────────────────────────────┤
│                                                                               │
│  Records identified from databases (n = 1,159)                                │
│  ┌─────────────────────────────────────────────────────────────────────┐      │
│  │ IEEE Xplore: 318 │ ACM DL: 178 │ ScienceDirect: 252 │ Springer: 211 │      │
│  │ Scopus: 140      │ WoS: 60     │                                   │      │
│  └─────────────────────────────────────────────────────────────────────┘      │
│                              │                                                │
│                              ▼                                                │
│  Records removed before screening:                                            │
│  • Duplicate records removed (n = 77)                                        │
│  • Records marked as ineligible by automation tools (n = 0)                  │
│                              │                                                │
│                              ▼                                                │
│  Records screened (n = 1,082)  ──────────────────────────────────────────┐   │
│                              │                                           │   │
│                              ▼                                           │   │
│  Records excluded (n = 840)  ◀───────────────────────────────────────────┘   │
│  • Not AI-DME (n = 312)                                                     │
│  • No technical contribution (n = 198)                                      │
│  • Wrong "model" meaning (n = 156)                                          │
│  • Editorials/abstracts (n = 98)                                            │
│  • Duplicates (n = 76)                                                      │
│                              │                                                │
│                              ▼                                                │
│  Reports sought for retrieval (n = 242)                                     │
│                              │                                                │
│                              ▼                                                │
│  Reports not retrieved (n = 18)                                             │
│                              │                                                │
│                              ▼                                                │
│  Reports assessed for eligibility (n = 224)                                 │
│                              │                                                │
│                              ▼                                                │
│  Reports excluded (n = 138)                                                 │
│  • No AI technique (n = 42)                                                 │
│  • No model engineering (n = 38)                                            │
│  • Insufficient methodology (n = 28)                                        │
│  • Out of scope domain (n = 30)                                             │
│                              │                                                │
│                              ▼                                                │
│  Studies included in review (n = 86)                                        │
│                                                                               │
└─────────────────────────────────────────────────────────────────────────────────┘

Records identified from other sources:
• Citation searching (n = 34)
• Snowballing (n = 28)
• Total other sources (n = 62)

Total included: 86 studies
```

*Adapted from PRISMA 2020 flow diagram for new systematic reviews*

---

## 13. Risk Register

| **Risk ID** | **Risk** | **Likelihood** | **Impact** | **Mitigation** | **Owner** |
|---|---|---|---|---|---|
| R1 | Team member unavailability | Medium | High | Cross-training, buddy system | P1 |
| R2 | Too many papers to screen | Medium | Medium | Strict inclusion criteria, batch prioritisation | P3 |
| R3 | Inconsistent data extraction | Medium | High | Pilot testing, regular calibration meetings | P4 |
| R4 | Inconsistent quality scoring | Medium | Medium | Pair cross-check, calibration sessions | P5 |
| R5 | Low-quality papers dominate | Low | Medium | Evidence weighting by QA score | P5 |
| R6 | Time overrun | Medium | High | Weekly progress checks, buffer days | P1 |
| R7 | Technology issues | Low | Medium | Backups, shared cloud storage | P7 |
| R8 | Scope creep | Medium | High | Strict scope definition, regular reviews | P1 |

---

## 14. Communication Plan

| **Meeting** | **Frequency** | **Duration** | **Purpose** | **Lead** |
|---|---|---|---|---|
| Kick-off | Once | 90 min | Role assignment, protocol finalisation | P1 |
| Daily stand-up | Daily (15 min) | 15 min | Progress updates, blockers | Rotating |
| Weekly review | Weekly (Fri) | 60 min | Phase completion, quality check | P1 |
| Calibration session | As needed | 30-45 min | QA/Extraction consistency | P4/P5 |
| Final review | Week 6 | 120 min | Manuscript review, presentation prep | All |

**Communication Tools:**
- **Primary:** WhatsApp/Teams for daily coordination
- **Documentation:** Google Drive/SharePoint for shared files
- **Tracking:** Excel workbook (SLR_Team_Tracker)
- **Reference Management:** Zotero/Mendeley

---

## 15. Appendices Checklist

| **Appendix** | **Description** | **Status** |
|---|---|---|
| A | SLR Protocol Document | To be developed |
| B | PRISMA 2020 Checklist (27 items) | To be completed |
| C | PRISMA Flow Diagram | To be created |
| D | Complete Screening Tracker (Excel) | To be completed |
| E | Full-Text Eligibility Log | To be completed |
| F | Data Extraction Database (Excel) | To be completed |
| G | Quality Assessment Scores (Excel) | To be completed |
| H | Taxonomy Diagram | To be created |
| I | Maturity Model Diagram | To be created |
| J | Reference Architecture Diagram | To be created |
| K | Gap Matrix | To be created |

---

## 16. Declaration of AI Usage

*To be included in final manuscript per requirements:*

> **Declaration of AI Usage:** This systematic literature review was conducted using AI tools for literature search assistance, reference management, and initial data organisation. All screening decisions, quality assessments, data extraction, synthesis, and writing were performed by the human authors. AI was used as an assistive tool only, with all outputs subject to human verification and accountability. The specific AI tools used and their roles are documented in Appendix [X].

---

*This Project Charter and WBS has been developed in accordance with PRISMA 2020 reporting guidelines, Kitchenham's guidelines for systematic literature reviews in software engineering, and the course assessment rubric for APT470S.*

**Version:** 1.0 | **Date:** 2026 | **Status:** Final