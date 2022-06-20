package context;

import domain.BankAccount;
import domain.BankBranch;
import domain.Employee;
import repository.*;
import service.*;
import util.HibernateUtil;

import javax.persistence.EntityManager;

public  class ApplicationContext {
    private static final ApplicationContext instance = new ApplicationContext();

   private final EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

    private   BankAccountRepository bankAccountRepository = new BankAccountRepositoryImpl(entityManager);
    private BankBranchRepository  bankBranchRepository = new BankBranchRepositoryImpl(entityManager);
    private BankCardRepository bankCardRepository = new BankCardRepositoryImpl(entityManager);
    private CustomerRepository customerRepository = new CustomerRepositoryImpl(entityManager);
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(entityManager);
    private TurnoverRepository turnoverRepository = new  TurnoverRepositoryIml(entityManager);
    private UserRepository userRepository = new UserRepositoryIml(entityManager);



    private BankBranchService bankBranchService = new BankBranchServiceImpl(bankBranchRepository);
    private BankCardService bankCardService = new BankCardServiceImpl(bankCardRepository);
    private  CustomerService customerService = new CustomerServiceImpl(customerRepository);
    private EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository);
    private UserService userService = new UserServiceImpl(userRepository);
    private BankAccountService bankAccountService = new BankAccountServiceImpl(bankAccountRepository, userService);
    private TurnoverService turnoverService = new TurnoverServiceImpl(turnoverRepository, bankAccountRepository);

    private Employee employee = new Employee();
    private BankAccount bankAccount = new BankAccount();
    private BankBranch bankBranch =new BankBranch();

    public static ApplicationContext getInstance() {
        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public BankAccountRepository getBankAccountRepository() {
        return bankAccountRepository;
    }

    public void setBankAccountRepository(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankBranchRepository getBankBranchRepository() {
        return bankBranchRepository;
    }

    public void setBankBranchRepository(BankBranchRepository bankBranchRepository) {
        this.bankBranchRepository = bankBranchRepository;
    }

    public BankCardRepository getBankCardRepository() {
        return bankCardRepository;
    }

    public void setBankCardRepository(BankCardRepository bankCardRepository) {
        this.bankCardRepository = bankCardRepository;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public TurnoverRepository getTurnoverRepository() {
        return turnoverRepository;
    }

    public void setTurnoverRepository(TurnoverRepository turnoverRepository) {
        this.turnoverRepository = turnoverRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public BankAccountService getBankAccountService() {
        return bankAccountService;
    }

    public void setBankAccountService(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    public BankBranchService getBankBranchService() {
        return bankBranchService;
    }

    public void setBankBranchService(BankBranchService bankBranchService) {
        this.bankBranchService = bankBranchService;
    }

    public BankCardService getBankCardService() {
        return bankCardService;
    }

    public void setBankCardService(BankCardService bankCardService) {
        this.bankCardService = bankCardService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public TurnoverService getTurnoverService() {
        return turnoverService;
    }

    public void setTurnoverService(TurnoverService turnoverService) {
        this.turnoverService = turnoverService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }
}
