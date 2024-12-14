package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        Assert.assertNotEquals("Job ID's should be unique",job1.getId(),job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertEquals("Job name should be 'Product tester'", "Product tester",job3.getName());
        Assert.assertEquals("Employer name should be 'ACME'", "ACME",job3.getEmployer().getValue());
        Assert.assertEquals("Location name should be 'Desert'", "Desert",job3.getLocation().getValue());
        Assert.assertEquals("Position type should be 'Quality control'", "Quality control",job3.getPositionType().getValue());
        Assert.assertEquals("Core competency should be 'Persistence'", "Persistence",job3.getCoreCompetency().getValue());

        Assert.assertTrue("Employer should not be null",job3.getEmployer()!=null);
        Assert.assertTrue("Location should not be null",job3.getLocation()!=null);
        Assert.assertTrue("Position type should not be null",job3.getPositionType()!=null);
        Assert.assertTrue("Core competency should not be null",job3.getCoreCompetency()!=null);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job job2 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Assert.assertFalse("Jobs should not be equal because their ids are different",job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job();

        String jobString = job.toString();

        String newLine = System.lineSeparator();

        Assert.assertEquals("The string should start with a new line", newLine, jobString.substring(0, newLine.length()));
        Assert.assertEquals("The string should end with a new line", newLine, jobString.substring(jobString.length() - newLine.length()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Web Developer", new Employer(""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));

        String jobString = job.toString();

        Assert.assertTrue(jobString.contains("Name: Web Developer"));
        Assert.assertTrue(jobString.contains("Employer: Data not available"));
        Assert.assertTrue(jobString.contains("Location: StL"));
        Assert.assertTrue(jobString.contains("Position Type: Data not available"));
        Assert.assertTrue(jobString.contains("Core Competency: Java"));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Web Developer",
                new Employer("LaunchCode"),
                new Location("StL"),
                new PositionType("Back-end developer"),
                new CoreCompetency("Java"));

        Assert.assertTrue(job.toString().contains("Web Developer"));
        Assert.assertTrue(job.toString().contains("LaunchCode"));
        Assert.assertTrue(job.toString().contains("StL"));
        Assert.assertTrue(job.toString().contains("Back-end developer"));
        Assert.assertTrue(job.toString().contains("Java"));
    }

}
