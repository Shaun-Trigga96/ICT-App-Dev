///*
//package za.ac.cput.repository.financialAid.impl;
//
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import za.ac.cput.entity.financialAid.Funding;
//import za.ac.cput.factory.financialAid.FundingFactory;
//import za.ac.cput.repository.financialAid.FundingRepository;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
////Comment out this test
//public class FundingRepositoryImplTest {
//
//    private static FundingRepository repository = FundingRepositoryImpl.getRepository();
//    private static Funding funding = FundingFactory.createFunding("Metropolitan", "matric");
//
//    @Test
//    public void d_getAll() { System.out.println("Get All: " + repository.getAll()); }
//
//    @Test
//    public void a_create()
//    {
//        Funding created = repository.create(funding);
//        Assert.assertEquals(funding.getFundingName(), created.getFundingName());
//        Assert.assertEquals(funding.getFundingRequirements(), created.getFundingRequirements());
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    public void b_read()
//    {
//        Funding read = repository.read(funding.getFundingId());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update()
//    {
//        Funding updated = new Funding.Builder().copy(funding).setFundingRequirements("national diploma").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void e_delete()
//    {
//        boolean deleted = repository.delete(funding.getFundingId());
//        Assert.assertTrue(deleted);
//    }
//}*/
