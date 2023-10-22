package tn.esprit.devops_project.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.Stock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@ActiveProfiles("test")
class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    @DatabaseSetup("/data-set/product-data.xml")
    void addProduct() {
        final Product product = new Product();
        product.setTitle("product2");
    /*    this.productService.addProduct(product,2L);
        assertEquals(this.productService.retreiveAllProduct().size(),2);
        assertEquals(this.productService.retrieveProduct(2L).getTitle(),"Product2");
   */
    }

    @Test
    @DatabaseSetup("/data-set/product-data.xml")
    void retrieveProduct() {
        final Product product = this.productService.retrieveProduct(1L);
        assertEquals("product ", product.getTitle());
    }
    @DatabaseSetup("/data-set/product-data.xml")
    @Test
    void retreiveAllProduct() {
        final List<Product> allProducts = this.productService.retreiveAllProduct();
        assertEquals(allProducts.size(), 1);

    }

    @Test
    void retrieveProductByCategory() {
    }

    @Test
    void deleteProduct() {
    }
}