/*
     * Click nbproject://.netbeans/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbproject://.netbeans/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package nongsan.webmvc.dao.impl;

import java.sql.Date;
import java.util.List;
import static junit.runner.Version.id;
import nongsan.webmvc.model.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AnhPV
 */
public class ProductDaoImplTest {

    private ProductDaoImpl dao;

    public ProductDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Setting up test environment...");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Tearing down test environment...");
    }

    @Before
    public void setUp() {
        dao = new ProductDaoImpl();
        // Clean up data before each test
        try {
//            dao.deleteAll();
        } catch (Exception e) {

        }
    }

    @After
    public void tearDown() {
//            dao.deleteAll();
    }

    // ======================== Test insert ========================
    @Test
    public void testInsert_Normal_Valid1() {
        Product product = new Product(
                null, "2", "Test", "1000", "1", "High-end laptop",
                "Good", "5", "test.jpg", "2025-06-22"
        );
        try {
            dao.insert(product);
            List<Product> list = dao.getAll();
            assertFalse(list.isEmpty());
            assertEquals("Test", list.get(list.size() - 1).getName());
            System.out.println("Inserted ProductID: " + list.get(list.size() - 1).getId() + ", Result: Success");
        } catch (Exception e) {
            System.out.println("Inserted ProductID: null, Result: Failed - " + e.getMessage());
            fail("Insertion failed: " + e.getMessage());
        }
    }

    @Test
    public void testInsert_Normal_Valid2() {
        Product product = new Product(
                null, "2", "Test", "1000", "1", "",
                "Good", "5", "test.jpg", "2025-06-22"
        );
        try {
            dao.insert(product);
            List<Product> list = dao.getAll();
            assertFalse(list.isEmpty());
            assertEquals("Test", list.get(list.size() - 1).getName());
            System.out.println("Inserted ProductID: " + list.get(list.size() - 1).getId() + ", Result: Success");
        } catch (Exception e) {
            System.out.println("Inserted ProductID: null, Result: Failed - " + e.getMessage());
            fail("Insertion failed: " + e.getMessage());
        }
    }

    @Test
    public void testInsert_Normal_Valid3() {
        Product product = new Product(
                null, "2", "Test", "1000", "1", "High-end laptop",
                "Good", "5", "null", "2025-06-22"
        );
        try {
            dao.insert(product);
            List<Product> list = dao.getAll();
            assertFalse(list.isEmpty());
            assertEquals("Test", list.get(list.size() - 1).getName());
            System.out.println("Inserted ProductID: " + list.get(list.size() - 1).getId() + ", Result: Success");
        } catch (Exception e) {
            System.out.println("Inserted ProductID: null, Result: Failed - " + e.getMessage());
            fail("Insertion failed: " + e.getMessage());
        }
    }

    @Test
    public void testInsert_Abnormal_NullProduct() {
        try {
            dao.insert(null);
            System.out.println("Inserted ProductID: null, result: Failed - Should have thrown exception");
            fail("Should throw NullPointerException");
        } catch (NullPointerException e) {
            System.out.println("Inserted ProductID: null, result: Success - Caught NullPointerException");
            assertTrue(true);
        } 
    }

    @Test
    public void testInsert_Boundary_EmptyName() {
        Product product = new Product(
                null, "2", "", "75000", "1", "Test Description",
                "Test Content", "5", "test_image.jpg", "2020-05-22"
        );

        try {
            dao.insert(product);
            System.out.println("Inserted ProductID: null, result: Failed - Should have thrown exception");
            fail("Should throw exception due to empty name");
        } catch (Exception e) {
            System.out.println("Inserted ProductID: null, result: Success - Caught exception");
            assertTrue(true); 
        }
    }

    // ======================== Test edit ========================
    @Test
    public void testEdit_Normal() {
        String existingId = "9";
        Product updatedProduct = new Product(
                existingId, "2", "Updated Product", "85000", "1", "Updated Description",
                "Updated Content", "5", "updated_image.jpg", "2020-05-22"
        );
        try {
            dao.edit(updatedProduct);
            Product result = dao.get(Integer.parseInt(existingId));
            System.out.println("Updated ProductID: " + existingId + ", result: Success");
            assertEquals("Updated Product", result.getName());
            assertEquals("85000", result.getPrice());
        } catch (Exception e) {
            System.out.println("Updated ProductID: " + existingId + ", result: Failed - " + e.getMessage());
            fail("Edit failed: " + e.getMessage());
        }
    }

    @Test
    public void testEdit_Normal2() {
        String existingId = "9";
        Product updatedProduct = new Product(
                existingId, "2", "Updated Product", "85000", "1", "",
                "Updated Content", "5", "null", "2020-05-22"
        );
        try {
            dao.edit(updatedProduct);
            Product result = dao.get(Integer.parseInt(existingId));
            System.out.println("Updated ProductID: " + existingId + ", result: Success");
            assertEquals("Updated Product", result.getName());
            assertEquals("85000", result.getPrice());
        } catch (Exception e) {
            System.out.println("Updated ProductID: " + existingId + ", result: Failed - " + e.getMessage());
            fail("Edit failed: " + e.getMessage());
        }
    }

//    @Test
//    public void testEdit_Normal() {
//        Product product = new Product(
//                null, "2", "Original Product", "75000", "1", "Original Description",
//                "Original Content", "5", "original_image.jpg", "2020-05-22"
//        );
//        try {
//            dao.insert(product);
//            List<Product> list = dao.getAll();
//            String id = list.get(list.size() - 1).getId();
//            Product updatedProduct = new Product(
//                    id, "2", "Updated Product", "85000", "1", "Updated Description",
//                    "Updated Content", "5", "updated_image.jpg", "2020-05-22"
//            );
//
//            dao.edit(updatedProduct);
//            Product result = dao.get(Integer.parseInt(id));
//            System.out.println("Updated ProductID: " + id + ", result: Success");
//            assertEquals("Updated Product", result.getName());
//            assertEquals("85000", result.getPrice());
//        } catch (Exception e) {
//            System.out.println("Updated ProductID: " + (product.getId() != null ? product.getId() : "null") + ", result: Failed - " + e.getMessage());
//            fail("Edit failed: " + e.getMessage());
//        }
//    }
    @Test
    public void testEdit_Abnormal_InvalidId() {

        String invalidId = "-1"; // id không hợp lệ, không tồn tại trong DB
        Product product = new Product(
                invalidId, "2", "Invalid Update", "75000", "1", "Test Description",
                "Test Content", "5", "test_image.jpg", "2020-05-22"
        );
        try {
            dao.edit(product);
            System.out.println("Updated ProductID: " + invalidId + ", result: Failed - Should have thrown exception");
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("Updated ProductID: " + invalidId + ", result: Success - Caught IllegalArgumentException");
            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Updated ProductID: " + invalidId + ", result: Failed - Expected IllegalArgumentException, but threw: " + e.getClass().getName());
            fail("Should throw IllegalArgumentException, but threw: " + e.getClass().getName());
        }
    }
    
        @Test
    public void testEdit_Abnormal_InvalidId2() {

        String invalidId = "null"; // id không hợp lệ, không tồn tại trong DB
        Product product = new Product(
                invalidId, "2", "Invalid Update", "75000", "1", "Test Description",
                "Test Content", "5", "test_image.jpg", "2020-05-22"
        );
        try {
            dao.edit(product);
            System.out.println("Updated ProductID: " + invalidId + ", result: Failed - Should have thrown exception");
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("Updated ProductID: " + invalidId + ", result: Success - Caught IllegalArgumentException");
            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Updated ProductID: " + invalidId + ", result: Failed - Expected IllegalArgumentException, but threw: " + e.getClass().getName());
            fail("Should throw IllegalArgumentException, but threw: " + e.getClass().getName());
        }
    }
    
        @Test
    public void testEdit_Abnormal_InvalidId3() {

        String invalidId = "abc"; // id không hợp lệ, không tồn tại trong DB
        Product product = new Product(
                invalidId, "2", "Invalid Update", "75000", "1", "Test Description",
                "Test Content", "5", "test_image.jpg", "2020-05-22"
        );
        try {
            dao.edit(product);
            System.out.println("Updated ProductID: " + invalidId + ", result: Failed - Should have thrown exception");
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("Updated ProductID: " + invalidId + ", result: Success - Caught IllegalArgumentException");
            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Updated ProductID: " + invalidId + ", result: Failed - Expected IllegalArgumentException, but threw: " + e.getClass().getName());
            fail("Should throw IllegalArgumentException, but threw: " + e.getClass().getName());
        }
    }
    

    // ======================== Test delete ========================
    @Test
    public void testDelete_Normal() {
        String existingId = "10"; 
        try {
            dao.delete(existingId);
            System.out.println("Deleted ProductID: " + existingId + ", result: Success");
            assertNull(dao.get(Integer.parseInt(existingId))); 
        } catch (Exception e) {
            System.out.println("Deleted ProductID: " + existingId + ", result: Failed - " + e.getMessage());
            fail("Deletion failed: " + e.getMessage());
        }
    }

    @Test
    public void testDelete_Boundary_NullId() {
        try {
            dao.delete(null);
            System.out.println("Deleted ProductID: null, result: Failed - Should have thrown exception");
            fail("Should throw NullPointerException");
        } catch (NullPointerException e) {
            System.out.println("Deleted ProductID: null, result: Success - Caught NullPointerException");
            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Deleted ProductID: null, result: Failed - Expected NullPointerException, but threw: " + e.getClass().getName());
            fail("Should throw NullPointerException or SQL exception, but threw: " + e.getClass().getName());
        }
    }

    // ======================== Test get ========================
    @Test
    public void testGet_Normal() {
        int existingId = 50; 
        try {
            Product result = dao.get(existingId);
            System.out.println("Retrieved ProductID: " + existingId + ", result: Success");
            assertNotNull(result);
            assertEquals("Test", result.getName());
        } catch (Exception e) {
            System.out.println("Retrieved ProductID: " + existingId + ", result: Failed - " + e.getMessage());
            fail("Get failed: " + e.getMessage());
        }
    }

    @Test
    public void testGet_Abnormal_NegativeId() {
        try {
            Product result = dao.get(-1);
            if (result == null) {
                System.out.println("Retrieved ProductID: -1, result: Success - No product found for negative ID");
            } else {
                System.out.println("Retrieved ProductID: -1, result: Failed - Unexpected product found: " + result.getName());
                fail("Unexpected product found for negative ID");
            }
            assertNull(result);
        } catch (Exception e) {
            System.out.println("Retrieved ProductID: -1, result: Failed - Unexpected exception: " + e.getMessage());
            e.printStackTrace();
            fail("Unexpected exception: " + e.getClass().getName());
        }
    }

    @Test
    public void testGet_Abnormal_EmptyId() {
        String invalidId = "";
        try {
            Product result = dao.get(Integer.parseInt(invalidId));
            System.out.println("Retrieved ProductID: " + invalidId + ", result: Failed - Unexpected result: " + (result != null ? result.getName() : "null"));
            fail("Should throw NumberFormatException for empty ID");
        } catch (NumberFormatException e) {
            System.out.println("Retrieved ProductID: " + invalidId + ", result: Success - Caught NumberFormatException: " + e.getMessage());
            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Retrieved ProductID: " + invalidId + ", result: Failed - Expected NumberFormatException, but threw: " + e.getClass().getName() + " - " + e.getMessage());
            fail("Should throw NumberFormatException, but threw: " + e.getClass().getName());
        }
    }

    @Test
    public void testGet_Abnormal_NonNumericId() {
        String invalidId = "abc";
        try {
            Product result = dao.get(Integer.parseInt(invalidId));
            System.out.println("Retrieved ProductID: " + invalidId + ", result: Failed - Unexpected result: " + (result != null ? result.getName() : "null"));
            fail("Should throw NumberFormatException for non-numeric ID");
        } catch (NumberFormatException e) {
            System.out.println("Retrieved ProductID: " + invalidId + ", result: Success - Caught NumberFormatException: " + e.getMessage());
            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Retrieved ProductID: " + invalidId + ", result: Failed - Expected NumberFormatException, but threw: " + e.getClass().getName() + " - " + e.getMessage());
            fail("Should throw NumberFormatException, but threw: " + e.getClass().getName());
        }
    }

    // ======================== Test getProductById ========================
    @Test
    public void testGetProductById_Normal() {
        int productId = 50;
        try {
            Product result = dao.get(productId);
            if (result != null) {
                System.out.println("Retrieved ProductID: " + productId + ", result: Success - Name: " + result.getName());
            } else {
                System.out.println("Retrieved ProductID: " + productId + ", result: Failed - Product not found");
                fail("Product with ID " + productId + " not found");
            }
            assertNotNull(result);
            assertEquals("Test", result.getName());
        } catch (Exception e) {
            System.out.println("Retrieved ProductID: " + productId + ", result: Failed - " + e.getMessage());
            fail("Get failed: " + e.getMessage());
        }
    }

    @Test
    public void testGetProductById_Abnormal_NegativeId() {
        int invalidCatalogId = -1;
        try {
            List<Product> results = dao.getProductById(invalidCatalogId);
            if (results == null || results.isEmpty()) {
                System.out.println("Retrieved Products by CatalogID: " + invalidCatalogId + ", result: Success - No products found for negative ID");
            } else {
                System.out.println("Retrieved Products by CatalogID: " + invalidCatalogId + ", result: Failed - Unexpected results: " + results.size() + " products found");
                fail("Unexpected results for negative CatalogID");
            }
            assertTrue(results == null || results.isEmpty());
        } catch (Exception e) {
            System.out.println("Retrieved Products by CatalogID: " + invalidCatalogId + ", result: Failed - Unexpected exception: " + e.getMessage());
            fail("GetProductById failed: " + e.getClass().getName());
        }
    }

    @Test
    public void testGetProductById_Abnormal_EmptyId() {
        int invalidCatalogId = 0; // Thay thế id rỗng bằng giá trị int không hợp lệ 0 
        try {
            List<Product> results = dao.getProductById(invalidCatalogId);
            if (results == null || results.isEmpty()) {
                System.out.println("Retrieved Products by CatalogID: " + invalidCatalogId + ", result: Success - No products found for invalid ID");
            } else {
                System.out.println("Retrieved Products by CatalogID: " + invalidCatalogId + ", result: Failed - Unexpected results: " + results.size() + " products found");
                fail("Unexpected results for invalid CatalogID");
            }
            assertTrue(results == null || results.isEmpty());
        } catch (Exception e) {
            System.out.println("Retrieved Products by CatalogID: " + invalidCatalogId + ", result: Failed - Unexpected exception: " + e.getMessage());
            fail("GetProductById failed: " + e.getClass().getName());
        }
    }

    @Test
    public void testGetProductById_Abnormal_NonNumericId() {
        int invalidCatalogId = -1; // Thay thế id không phải số bằng giá trị int không hợp lệ -1
        try {
            List<Product> results = dao.getProductById(invalidCatalogId);
            if (results == null || results.isEmpty()) {
                System.out.println("Retrieved Products by CatalogID: " + invalidCatalogId + ", result: Success - No products found for invalid ID");
            } else {
                System.out.println("Retrieved Products by CatalogID: " + invalidCatalogId + ", result: Failed - Unexpected results: " + results.size() + " products found");
                fail("Unexpected results for invalid CatalogID");
            }
            assertTrue(results == null || results.isEmpty());
        } catch (Exception e) {
            System.out.println("Retrieved Products by CatalogID: " + invalidCatalogId + ", result: Failed - Unexpected exception: " + e.getMessage());
            fail("GetProductById failed: " + e.getClass().getName());
        }
    }

    @Test
    public void testGetAll_Normal() {
        try {
            List<Product> results = dao.getAll();
            if (results != null) {
                System.out.println("Retrieved all products, result: Success - Total products: " + results.size());
                if (!results.isEmpty()) {
                    System.out.println("First product ID: " + results.get(0).getId() + ", Name: " + results.get(0).getName());
                } else {
                    System.out.println("No products found in database");
                }
            } else {
                System.out.println("Retrieved all products, result: Failed - Returned null");
                fail("Expected non-null list");
            }
            assertNotNull(results);
        } catch (Exception e) {
            System.out.println("Retrieved all products, result: Failed - Unexpected exception: " + e.getMessage());
            fail("GetAll failed: " + e.getMessage());
        }
    }

    @Test
    public void testGetAll_Abnormal_EmptyDatabase() {
        try {
            // Giả định xóa tất cả dữ liệu trước để test trường hợp DB rỗng
            dao.deleteAll();
            List<Product> results = dao.getAll();
            if (results != null && results.isEmpty()) {
                System.out.println("Retrieved all products, result: Success - Empty database confirmed");
            } else {
                System.out.println("Retrieved all products, result: Failed - Expected empty list, got: " + (results == null ? "null" : results.size() + " products"));
                fail("Expected empty list for empty database");
            }
            assertNotNull(results);
            assertTrue(results.isEmpty());
        } catch (Exception e) {
            System.out.println("Retrieved all products, result: Failed - Unexpected exception: " + e.getMessage());
            fail("GetAll failed: " + e.getMessage());
        }
    }

    // ======================== Test searchByName ========================
    @Test
    public void testSearchByName_Normal() {
        String searchKeyword = "Test";
        try {
            List<Product> results = dao.searchByName(searchKeyword);
            if (!results.isEmpty()) {
                String id = results.get(0).getId();
                System.out.println("Searched ProductID: " + id + ", result: Success - Keyword: " + searchKeyword);
            } else {
                System.out.println("Searched ProductID: null, result: Failed - No products found for keyword: " + searchKeyword);
                fail("No products found for keyword: " + searchKeyword);
            }
            assertNotNull(results);
            assertFalse(results.isEmpty());
            boolean found = results.stream().anyMatch(p -> p.getName().contains(searchKeyword));
            assertTrue(found);
        } catch (Exception e) {
            System.out.println("Searched ProductID: null, result: Failed - " + e.getMessage());
            fail("SearchByName failed: " + e.getMessage());
        }
    }

    @Test
    public void testSearchByName_Abnormal_EmptyKeyword() {
        String searchKeyword = "";
        try {
            List<Product> results = dao.searchByName(searchKeyword);
            if (results.isEmpty()) {
                System.out.println("Searched ProductID: null, result: Success - No results for empty keyword");
            } else {
                System.out.println("Searched ProductID: null, result: Failed - Unexpected results for empty keyword: " + results.size() + " products found");
                fail("Unexpected results for empty keyword");
            }
            assertNotNull(results);
            assertTrue(results.isEmpty());
        } catch (Exception e) {
            System.out.println("Searched ProductID: null, result: Failed - " + e.getMessage());
            fail("SearchByName failed: " + e.getMessage());
        }
    }
}
