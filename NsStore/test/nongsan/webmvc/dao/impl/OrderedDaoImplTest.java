package nongsan.webmvc.dao.impl;

import java.util.List;
import nongsan.webmvc.model.Ordered;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderedDaoImplTest {

    private OrderedDaoImpl dao;

    public OrderedDaoImplTest() {
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
        dao = new OrderedDaoImpl();
        // Clean up data before each test
        try {

        } catch (Exception e) {
            System.out.println("Cleanup failed: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        // Clean up data after each test
        try {

        } catch (Exception e) {
            System.out.println("Cleanup failed: " + e.getMessage());
        }
    }

// ======================== Test insert ========================
    @Test
    public void testInsert_Normal_Valid1() {
        Ordered ordered = new Ordered(null, "9", "2", 2); 
        try {
            dao.insert(ordered);
            List<Ordered> list = dao.getAll();
            assertFalse(list.isEmpty());
            Ordered lastOrdered = list.get(list.size() - 1);
            assertEquals("9", lastOrdered.getProduct_id());
            assertEquals("2", lastOrdered.getTransaction_id());
            assertEquals(2, lastOrdered.getQty());
            assertNotNull("Ordered ID should be generated", lastOrdered.getId());
            System.out.println("Inserted OrderedID: " + lastOrdered.getId() + ", Result: Success");
        } catch (Exception e) {
            System.out.println("Inserted OrderedID: null, Result: Failed - " + e.getMessage());
            fail("Insertion failed: " + e.getMessage());
        }
    }



    @Test
    public void testInsert_Abnormal_NullOrdered() {
        try {
            dao.insert(null);
            System.out.println("Inserted OrderedID: null, result: Failed - Should have thrown exception");
            fail("Should throw NullPointerException or RuntimeException");
        } catch (NullPointerException e) {
            System.out.println("Inserted OrderedID: null, result: Success - Caught NullPointerException");
            assertTrue(true);
        } catch (RuntimeException e) {
            System.out.println("Inserted OrderedID: null, result: Success - Caught RuntimeException: " + e.getMessage());
            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Inserted OrderedID: null, result: Failed - Unexpected exception: " + e.getMessage());
            fail("Unexpected exception: " + e.getClass().getName());
        }
    }

    @Test
    public void testInsert_Boundary_InvalidProductId() {
        Ordered ordered = new Ordered(null, "P001", "2", 5); // product_id không phải số
        try {
            dao.insert(ordered);
            System.out.println("Inserted OrderedID: null, result: Failed - Should have thrown exception");
            fail("Should throw NumberFormatException or RuntimeException");
        } catch (NumberFormatException e) {
            System.out.println("Inserted OrderedID: null, result: Success - Caught NumberFormatException: " + e.getMessage());
            assertTrue(true);
        } catch (RuntimeException e) {
            System.out.println("Inserted OrderedID: null, result: Success - Caught RuntimeException: " + e.getMessage());
            assertTrue(e.getMessage().contains("Invalid format"));
        } catch (Exception e) {
            System.out.println("Inserted OrderedID: null, result: Failed - Unexpected exception: " + e.getMessage());
            fail("Unexpected exception: " + e.getClass().getName());
        }
    }

    @Test
    public void testInsert_Boundary_NegativeQty() {
        Ordered ordered = new Ordered(null, "9", "2", -1); 
        try {
            dao.insert(ordered);
            System.out.println("Inserted OrderedID: null, result: Failed - Should have thrown exception");
            fail("Should throw RuntimeException or SQLException for negative qty");
        } catch (RuntimeException e) {
            System.out.println("Inserted OrderedID: null, result: Success - Caught RuntimeException: " + e.getMessage());
            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Inserted OrderedID: null, result: Failed - Unexpected exception: " + e.getMessage());
            fail("Unexpected exception: " + e.getClass().getName());
        }
    }
    
    // ======================== Test getAll ========================
    @Test
    public void testGetAll_Normal() {
        try {
            List<Ordered> results = dao.getAll();
            if (results != null) {
                System.out.println("Retrieved all orders, result: Success - Total orders: " + results.size());
                if (!results.isEmpty()) {
                    System.out.println("First order ID: " + results.get(0).getId() + ", Product ID: " + results.get(0).getProduct_id());
                } else {
                    System.out.println("No orders found in database");
                }
            } else {
                System.out.println("Retrieved all orders, result: Failed - Returned null");
                fail("Expected non-null list");
            }
            assertNotNull(results);
        } catch (Exception e) {
            System.out.println("Retrieved all orders, result: Failed - Unexpected exception: " + e.getMessage());
            fail("GetAll failed: " + e.getMessage());
        }
    }

//    @Test
//    public void testGetAll_Abnormal_EmptyDatabase() {
//        try {
//            List<Ordered> results = dao.getAll();
//            if (results != null && results.isEmpty()) {
//                System.out.println("Retrieved all orders, result: Success - Empty database confirmed");
//            } else {
//                System.out.println("Retrieved all orders, result: Failed - Expected empty list, got: " + (results == null ? "null" : results.size() + " orders"));
//                fail("Expected empty list for empty database");
//            }
//            assertNotNull(results);
//            assertTrue(results.isEmpty());
//        } catch (Exception e) {
//            System.out.println("Retrieved all orders, result: Failed - Unexpected exception: " + e.getMessage());
//            fail("GetAll failed: " + e.getMessage());
//        }
//    }
}