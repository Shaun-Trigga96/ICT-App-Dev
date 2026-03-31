package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.repository.CustomerRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.class)
class CustomerServiceImplTest {

    private CustomerServiceImpl customerServiceImpl;

    private static  Name name = NameFactory.build("Thabiso", "Patrick", "Matsaba");

    private static  Name name2 = NameFactory.build("Shaun", "", "Brown");

    private static Customer customer = CustomerFactory.build("CUS101", name);

    private static Customer customer2 = CustomerFactory.build("CUS102", name2);


    @Mock
    CustomerRepository customerRepository;

    @BeforeEach
    void setup(){
        customerServiceImpl = new CustomerServiceImpl(customerRepository);
    }

    @Test
    @Order(1)
    void save() {
        customerServiceImpl.save(customer);
        ArgumentCaptor<Customer> argumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository).save(argumentCaptor.capture());
        Customer capturedCustomer = argumentCaptor.getValue();
        assertThat(capturedCustomer).isEqualTo(customer);
        System.out.println(customer);
    }

    @Test
    @Order(2)
    void read() {
        customerServiceImpl.read("CUS101");
        verify(customerRepository).findById(customer.getCustomerId());
        assertNotNull(customer.getCustomerId());
        System.out.println(customer);
    }

    @Test
    @Order(3)
    @Disabled
    void update() {
        customerServiceImpl.update(customer2);
        ArgumentCaptor<Customer> argumentCaptor2 = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository.existsById(customer2.getCustomerId()));
        Customer capturedCustomer2 = argumentCaptor2.getValue();
        assertThat(capturedCustomer2).isEqualTo(customer2);
        System.out.println(customer2);
    }
    @Test
    @Order(4)
    void delete() {
        customerServiceImpl.delete("CUS101");
        verify(customerRepository).existsById(customer.getCustomerId());
        System.out.println("Deleted Id:" + customer.getCustomerId());
    }

    @Test
    @Order(5)
    void findAll() {
        customerServiceImpl.findAll();
        verify(customerRepository).findAll();
        System.out.println(customer);
        System.out.println(customer2);
    }

    @Test
    @Order(6)
    @Disabled
    void deleteById() {
    }
}