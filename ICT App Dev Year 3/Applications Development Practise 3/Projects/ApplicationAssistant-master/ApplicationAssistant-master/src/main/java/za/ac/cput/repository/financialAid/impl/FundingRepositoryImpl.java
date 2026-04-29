//package za.ac.cput.repository.financialAid.impl;
//
//import za.ac.cput.entity.financialAid.Funding;
//import za.ac.cput.repository.financialAid.FundingRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//@Deprecated
//public class FundingRepositoryImpl implements FundingRepository {
//
//    private static FundingRepository repository = null;
//    private Set<Funding> fundingDB;
//
//    private FundingRepositoryImpl() { this.fundingDB = new HashSet<>(); }
//
//    public static FundingRepository getRepository() {
//        if(repository == null) repository = new FundingRepositoryImpl();
//        return repository;
//    }
//
//
//    @Override
//    public Set<Funding> getAll() {
//        return this.fundingDB;
//    }
//
//    @Override
//    public Funding create(Funding funding) {
//        this.fundingDB.add(funding);
//        return funding;
//    }
//
//    @Override
//    public Funding read(String fundingId) {
//        for (Funding funding : this.fundingDB)
//        {
//            if (funding.getFundingId().equalsIgnoreCase(fundingId)) return funding;
//        }
//        return null;
//    }
//
//    @Override
//    public Funding update(Funding funding) {
//        boolean deleteFunding = delete(funding.getFundingId());
//        if (deleteFunding)
//        {
//            this.fundingDB.add(funding);
//            return funding;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String fundingId) {
//        Funding funding = read(fundingId);
//        if (funding != null)
//        {
//            this.fundingDB.remove(funding);
//            return true;
//        }
//        return false;
//    }
//}
