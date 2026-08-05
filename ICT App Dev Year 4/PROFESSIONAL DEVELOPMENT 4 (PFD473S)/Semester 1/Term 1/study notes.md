Study Notes: FID-IT-PFD473S Project Management and Quantitative Analysis

1. Course and Administrative Overview

This section provides the administrative framework and identifies the essential resources for the subject FID-IT-PFD473S, as established in the official subject guide.

* Subject Code and Title: FID-IT-PFD473S Project Management and Quantitative Analysis.
* Administrative Categories:
  * Contact Information: Refer to Section 2.1 for faculty contact details and administrative support.
  * Class Times and Venues: Refer to Section 2.2 for specific lecture times, tutorial slots, and physical or virtual venues.
  * Study Materials: A comprehensive list of essential resources is provided in Section 3.
* Prescribed Materials: The core theoretical requirements for this course are found in the Prescribed Textbook, as identified in Section 3.1 of the subject guide.

2. Foundational Management Theories

The curriculum integrates historical management frameworks to provide a theoretical basis for project leadership and organizational structure.

* Henri Fayol’s Principles of Management: The specific principles and their applications are not explicitly detailed in the provided source fragments. As per the subject requirements, students must supplement this section by studying the detailed principles in the prescribed textbook mentioned in Section 3.1.
* Henry Mintzberg’s Managerial Roles: The categorization of Mintzberg’s specific managerial roles is not contained within the available documentation. Students are required to consult the prescribed textbook for a full analysis of these roles.

3. Program Evaluation and Review Technique (PERT)

The Program Evaluation and Review Technique (PERT) is a sophisticated project management tool used to schedule and coordinate tasks, specifically designed to handle the uncertainty inherent in project durations.

Definition and Core Concept

PERT is defined by its probabilistic nature. Unlike the Critical Path Method (CPM), which is deterministic and relies on fixed durations, PERT acknowledges that task completion times are variables.

The 50% Probability Rule

The PERT methodology establishes a specific baseline for project completion expectations:

The 50% Rule: When a time or duration for a project is calculated using PERT, it signifies that there is a 50% chance (a probability of 0.5) of finishing the project by that specific time.

Technically, the "mean" (\mu) calculated through PERT represents the point on the distribution curve where the Z-score is zero (Z = 0), corresponding exactly to a cumulative probability of 0.5000.

Comparison to CPM

PERT is described as being "very similar" to CPM in terms of logic and path analysis. However, the fundamental distinction remains the treatment of time: CPM uses single-point, fixed estimates, while PERT uses a weighted average of three different estimates to account for risk.

The Three-Point Estimate (The "Three Guesses")

To perform PERT calculations, managers must generate three distinct estimates for every project activity. To ensure mathematical accuracy in exams and applications, all durations must be converted to a consistent unit of measure (minutes).

Estimate Type	Designation	Duration (Source)	Duration (Standardized)
Optimistic	A	20 minutes	20 minutes
Most-likely	M	30 minutes	30 minutes
Pessimistic	B	1 hour	60 minutes

Visual Representation and Distribution

Quantitative analysis of these durations is visualized using a Normal Distribution (the Bell Curve).

* Academic Nuance: While the final analysis utilizing Z-tables assumes a Standard Normal Distribution, project managers should note that the initial "Three Guesses" in PERT often imply a distribution (such as a Beta distribution) that may be skewed based on the distance of the most-likely estimate from the optimistic and pessimistic extremes.

4. Statistical Analysis and Probability Reference

Quantitative project management requires the ability to interpret standard cumulative probabilities to move beyond the 50% baseline and determine the likelihood of project success at various deadlines.

Z-Table Interpretation

"Appendix A: TABLE A Standard Normal Cumulative Probabilities" serves as the primary technical reference for determining project confidence levels.

Definition of Value: Cumulative probability for z is the area under the standard normal curve to the left of z.

Data Range Summary

* Z-Value Range: The cumulative tables provided cover Z-values ranging from extreme negatives (-5.0) to high positives (3.4).
* The Median Point: At a Z-score of 0.00, the cumulative probability is exactly .5000.

Probability Constants for Extreme Values

For calculations resulting in Z-scores beyond the standard table, the following high-precision constants must be utilized:

* Z = -5.0: .000000287
* Z = -4.5: .00000340
* Z = -4.0: .0000317
* Z = -3.5: .000233
* Z = 3.5: .999767
* Z = 4.0: .9999683
* Z = 4.5: .9999966
* Z = 5.0: .999999713

Mathematical Notations

Students must be proficient in the following statistical symbols used in project duration and variance formulas:

* \mu: The mean (the expected duration of the project).
* \sigma: The standard deviation (representing the risk or spread of the durations).
* \Sigma: The summation symbol (used to calculate total path durations and variances).

5. Study Summary and Key Takeaways

* Shift from Deterministic to Probabilistic: PERT replaces the fixed-point timing of CPM with a three-point estimation model (A, M, B) to better reflect project reality.
* The 50% Median Baseline: The standard PERT calculation identifies the expected duration (\mu), which only carries a 50% likelihood of completion.
* Increasing Confidence via Z-Scores: To provide a deadline with a higher success probability (e.g., 95% or 99%), managers must calculate the number of standard deviations from the mean and use the Z-table to find the "area to the left."
* Technical Rigor: Success in this module requires unit consistency (standardizing hours to minutes) and the precise application of cumulative probability constants for extreme Z-values.
