# Extreme Programming – 10-Minute Presentation Script
**APT470S | Thabiso Matsaba | 220296006**

> 📌 **Pace guide:** ~130 words per minute. Total target: ~1,300 words.
> Each slide section includes a ⏱ timing marker to keep you on track.

---

## SLIDE 1 – Title Slide ⏱ 0:00–0:20

Good day. My name is Thabiso Matsaba, student number 220296006, and today I will be presenting my individual research and analysis on Extreme Programming — commonly known as XP — for the APT470S module, Applications Development Theory 4. Let's get into it.

---

## SLIDE 2 – Contents ⏱ 0:20–0:40

My presentation covers six research questions. I'll trace the origins of XP, examine its five core values, evaluate its key technical practices, explore the controversial practices, compare XP with other Agile methods, and finally, look at how XP has evolved into the modern DevOps era.

---

## SLIDE 3 – Introduction to XP ⏱ 0:40–1:10

Extreme Programming is one of the most technically prescriptive Agile methodologies ever developed. Unlike frameworks that focus primarily on process management, XP places engineering excellence at the centre of software development. It emphasises collaboration, close customer involvement, and delivering high-quality software through very short iterative cycles and continuous feedback. It was designed specifically to address the failure modes of traditional, plan-driven development in fast-changing commercial environments.

---

## SLIDE 4 – The Software Crisis ⏱ 1:10–1:40

To understand why XP emerged, we need to understand the 1990s software crisis. The Standish Group's Chaos Report of 1994 revealed that only 16% of software projects were completed on time and within budget, while 31% were cancelled outright. The dominant waterfall model, which assumed requirements could be fully specified upfront, proved chronically inadequate in environments where business needs shifted faster than traditional processes could accommodate. This crisis demanded something radically different.

---

## SLIDE 5 – Origins of XP ⏱ 1:40–2:20

Extreme Programming was developed by three key figures: Kent Beck, Ward Cunningham, and Ron Jeffries. Their collaboration dates to at least 1989, when Beck and Cunningham introduced CRC cards — a lightweight, collaborative design technique — at OOPSLA. The crucible for XP, however, was the Chrysler Comprehensive Compensation project, known as C3, which began in 1996. The C3 project aimed to consolidate multiple legacy payroll systems for approximately 87,000 Chrysler employees. Beck was brought in as a performance consultant and found not just technical problems, but fundamental process failures — poor communication, lack of testing discipline, and a team unable to collaborate effectively. His response was radical: apply every beneficial development practice he knew, but push each one to its extreme. That deliberate amplification of best practices gave this methodology its provocative name — Extreme Programming.

---

## SLIDE 6 – Historical Antecedents ⏱ 2:20–2:50

XP did not emerge in a vacuum. Pressman (2015) notes that its practices synthesised ideas that had existed informally for decades — test-first development had antecedents in NASA's Project Mercury in the 1960s, and refactoring was advocated as far back as 1984. What XP accomplished was to synthesise, name, and systematise these informal habits into a coherent, mutually reinforcing framework. The Agile Manifesto, signed in 2001, of which Beck was a co-author, provided the philosophical capstone to this practitioner-driven movement.

---

## SLIDE 7 – Core Values of XP ⏱ 2:50–3:10

XP is defined not just by its practices, but by five core values: Communication, Simplicity, Feedback, Courage, and Respect. Sommerville (2016) describes these as the social and collaborative underpinnings from which all technical practices derive their meaning. Let me walk through each one.

---

## SLIDE 8 – Communication in XP ⏱ 3:10–3:35

XP holds that most software project failures are, at their root, communication failures. The on-site customer practice addresses this most radically — a real customer representative sits with the team full-time, collapsing the traditional analyst-developer-customer triangle into a single collaborative unit. Pair programming operationalises communication at the code level: every line of code is simultaneously written and reviewed, meaning design decisions are continuously discussed and challenged. User stories create a shared language of business value and technical effort.

---

## SLIDE 9 – Simplicity & Feedback ⏱ 3:35–4:05

Simplicity in XP is not naïve — it is disciplined. Build what is needed now, in the simplest form that works, with tests to protect against regression. This is captured in the YAGNI principle: You Aren't Gonna Need It. XP generates feedback at multiple timescales simultaneously. Unit tests provide millisecond feedback on individual functions; the on-site customer provides daily feedback on story implementation; and iteration demos provide weekly feedback on direction. This multilayered feedback architecture — where testing is embedded into every moment of development rather than deferred to a final phase — is arguably XP's most significant contribution to software engineering.

---

## SLIDE 10 – Courage & Respect ⏱ 4:05–4:30

Courage in XP means making difficult decisions when they are correct but uncomfortable — refactoring aggressively when the architecture is wrong, giving honest estimates rather than optimistic projections, and telling the customer when a story is harder than anticipated. As Sommerville (2016) notes, this courage is only sustainable when backed by a comprehensive test suite. Respect, added as the fifth value in Beck's 2004 second edition, operationalises itself through collective code ownership — no developer gatekeeps any part of the codebase — and through the mutual accountability of pair programming.

---

## SLIDE 11 – Core XP Practices ⏱ 4:30–4:55

XP's core practices form a mutually reinforcing system. The six I'll focus on are: Test-Driven Development, Pair Programming, Collective Code Ownership, Continuous Integration, On-site Customer, and Refactoring. Each practice supports and is supported by the others. TDD and Continuous Integration provide the safety net that makes collective ownership and aggressive refactoring possible; the on-site customer makes the feedback loop fast enough for short iterations to deliver value.

---

## SLIDE 12 – Empirical Evidence (TDD) ⏱ 4:55–5:25

Of all XP's practices, TDD has the strongest empirical support. The red-green-refactor cycle — write a failing test, write minimal code to pass it, then refactor — embeds quality into the act of development itself. Nagappan et al. (2008), in one of the most rigorous industry studies, found that four Microsoft and IBM teams using TDD experienced 40 to 90% reductions in defect density, at a cost of only 15 to 35% additional development time. Rafique and Misić's 2013 meta-analysis of 27 TDD studies confirmed a statistically significant positive effect on external quality, with stronger effects in industrial settings. Critical evaluation reveals that TDD's benefits are context-dependent — it has a steep learning curve and is less suited to exploratory research programming. But despite these caveats, TDD has been adopted far beyond the XP community.

---

## SLIDE 13 – Evidence of Effectiveness: Pair Programming & CI ⏱ 5:25–5:55

Williams et al. (2000) found that paired developers produced code of comparable quality to solo developers in roughly half the calendar time, with an effort overhead of only about 15%. Hannay et al.'s 2010 systematic mapping of 154 industrial studies found consistent positive effects on quality and knowledge transfer, though mixed results on productivity when measured narrowly by lines of code — a metric that systematically undervalues pair programming by ignoring reduced rework costs. Continuous Integration produces what XP practitioners call the 'always green mainline' — a codebase that always has a working, tested version available. This principle has become the foundation of modern CI/CD pipelines across the industry.

---

## SLIDE 14 – Controversial Practices ⏱ 5:55–6:30

Pair programming and on-site customer are XP's most contested practices. Critics such as Boehm and Turner (2004) argue that requiring two developers at one machine is economically irrational. Defenders counter that this ignores the compounding cost of defects caught later. The on-site customer requirement is widely acknowledged as XP's most difficult practice to implement — domain experts are typically the same people most needed for operational work. Remote work has intensified both challenges. However, research shows pair programming survives geographic separation with tools like VSCode Live Share. And BDD frameworks such as Cucumber allow customer participation in acceptance criteria asynchronously, preserving the spirit of the practice without requiring full-time physical presence. Scrum's product owner role is essentially a formalised, moderated version of XP's on-site customer.

---

## SLIDE 15 – XP vs. Other Agile Methods ⏱ 6:30–7:05

XP occupies the most technically prescriptive position of any mainstream Agile methodology. Scrum provides a process framework but is deliberately silent on technical practices — a Scrum team may or may not use TDD. XP makes the opposite claim: that technical excellence is the prerequisite of agility. Without TDD, CI, and refactoring, codebases degrade under the pressure of frequent change, eventually slowing teams to a halt regardless of how well their ceremonies are run. Cohn (2005) identifies four key differences between Scrum and XP: iteration length, ability to change mid-iteration, priority ordering, and technical prescription. Crystal manages social dynamics; FDD manages feature pipelines; Scrum manages process. XP manages the quality of the code itself. Many high-performing teams today run Scrum ceremonies while applying XP engineering practices — a hybrid sometimes called ScrumXP.

---

## SLIDE 16 – Evolution of XP ⏱ 7:05–7:35

XP has evolved significantly since Beck's first edition in 1999. The second edition in 2004 added Respect as a fifth value, introduced primary versus corollary practices, and moderated some of the more absolutist prescriptions. Practices like the system metaphor and the 40-hour week have largely faded or been adapted. The metaphor practice was too vague in application and has been replaced by more structured approaches like Domain-Driven Design. The sustainable pace principle survives as a statement of intent but often fails as a hard constraint in competitive environments.

---

## SLIDE 17 – XP in DevOps ⏱ 7:35–8:10

The practices that have most endured are TDD, Continuous Integration, and short iterations — and they have migrated far beyond the XP community into mainstream software engineering. The emergence of DevOps in the 2010s validated XP's core assumptions at scale. Continuous deployment, releasing to production multiple times per day, is a direct extension of XP's small releases principle. Infrastructure-as-code tools like Terraform apply XP-like principles — version-controlled, test-driven, incrementally deployed — to infrastructure management. Trunk-based development, where all developers commit directly to the main branch multiple times per day, is a direct continuation of XP's continuous integration principle, adapted for modern distributed version control. XP's influence on software engineering extends well beyond the Agile community.

---

## SLIDE 18 – Key Takeaways ⏱ 8:10–8:45

To summarise: XP emerged from a specific industrial crisis in the mid-1990s as a technically prescriptive methodology that pushed proven engineering practices to their logical extremes. Its five values — Communication, Simplicity, Feedback, Courage, and Respect — form the philosophical foundation for a set of mutually reinforcing technical practices. TDD and Continuous Integration have the strongest empirical support and have achieved mainstream adoption. Pair programming and on-site customer remain effective but context-dependent practices that have been substantially adapted for distributed, remote work environments. XP's greatest legacy is not any single practice, but the principle that engineering excellence and agility are inseparable — you cannot sustainably deliver at speed without quality, and you cannot maintain quality without the discipline of XP's technical practices.

---

## SLIDE 19 – References ⏱ 8:45–8:55

My research is grounded in the two prescribed textbooks — Sommerville (2016) and Pressman (2015) — supplemented by ten peer-reviewed academic sources including meta-analyses by Hannay et al., Rafique and Misić, and industry studies by Nagappan et al. Full references are listed here in APA 7th edition format.

---

## SLIDE 20 – Questions & Discussion ⏱ 8:55–9:20

I'm happy to take any questions on the material covered. Whether it's the empirical evidence around TDD, the remote work adaptations for pair programming, or XP's relationship with modern DevOps — I welcome the discussion.

---

## SLIDE 21 – Thank You ⏱ 9:20–10:00

Thank you for your time and attention. I hope this presentation has provided both a comprehensive overview and a critical analysis of Extreme Programming — a methodology that, more than 25 years after its birth on the Chrysler factory floor, continues to shape how software is built around the world. Thank you.

---

> ✅ **Total estimated time:** ~10 minutes at a natural pace of 130 words/min
> 💡 **Tip:** Do a practice run with a stopwatch. If you're running short, slow down on slides 12–15 (empirical evidence sections). If running long, trim the Q&A slide and keep the references slide to one sentence.
