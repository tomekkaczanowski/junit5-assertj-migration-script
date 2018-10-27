This script helps to migrate JUnit 5 assertions to AssertJ. Based on scripts for JUnit4 found at 
http://joel-costigliola.github.io/assertj/assertj-core-converting-junit-assertions-to-assertj.html

Read this blog post http://testinglikeaboss.com/tips-tricks/migrating-from-junit-5-assertions-to-assertj/ to learn the details (and gotchas!) and check script source code for additional comments.

## Sample run
There are two identical Java files in `src/test/java/com/practicalunittesting`. When you execute

`bash `

then one of these files - JUnit5AssertionsTest.java - will be migrated to AssertJ assertions. Now run:

`brew install colordiff`
`diff src/test/java/com/practicalunittesting/JUnit5AssertionsTest.java src/test/java/com/practicalunittesting/OriginalTestToCompare.java | colordiff`

you will see the difference with OriginalTestToCompare.jave which was not migrated (because its name doesn't end with 'Test').

## Thank you
Happy migrating!
