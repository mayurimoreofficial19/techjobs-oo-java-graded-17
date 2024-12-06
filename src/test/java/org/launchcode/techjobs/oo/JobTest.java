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
}
