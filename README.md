# How to run from Terminal
**For web config local mode:**

gradle clean test --tests WebTest -Denv=local

**For web config remote mode:**

gradle clean test --tests WebTest -Denv=selenoid
