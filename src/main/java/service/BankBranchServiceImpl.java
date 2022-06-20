package service;


import domain.BankBranch;
import repository.BankBranchRepository;

public class BankBranchServiceImpl extends BaseServiceImpl<BankBranch,Integer, BankBranchRepository> implements BankBranchService {


    public BankBranchServiceImpl(BankBranchRepository repository) {
        super(repository);
    }
}
