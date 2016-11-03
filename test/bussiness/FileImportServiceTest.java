package bussiness;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yohan Romero
 */
public class FileImportServiceTest {

    public FileImportServiceTest() {
    }

    /**
     * Test of validatePassengerDocument method, of class FileImportService.
     */
    @Test
    public void testValidatePassengerDocument() {
        System.out.println("validatePassengerDocument");

        // CORRECT LENGTH
        String document = "12345678901234";
        boolean expResult = true;
        boolean result = FileImportService.validatePassengerDocument(document);
        assertEquals(expResult, result);

        // INCORRECT MIN LENGTH
        document = "123456789";
        expResult = false;
        result = FileImportService.validatePassengerDocument(document);
        assertEquals(expResult, result);

        // INCORRECT MAX LENGTH
        document = "1234567890123456";
        expResult = false;
        result = FileImportService.validatePassengerDocument(document);
        assertEquals(expResult, result);

        // INCORRECT
        document = "12345678abc";
        expResult = false;
        result = FileImportService.validatePassengerDocument(document);
        assertEquals(expResult, result);
    }

    /**
     * Test of validatePassengerName method, of class FileImportService.
     */
    @Test
    public void testValidatePassengerName() {
        System.out.println("validatePassengerName");

        // CORRECT ALPHANUMERIC
        String name = "PACO PEREZ 123";
        boolean expResult = true;
        boolean result = FileImportService.validatePassengerName(name);
        assertEquals(expResult, result);

        // INCORRECT CHARACTERS
        name = "PACO PEREZ @";
        expResult = false;
        result = FileImportService.validatePassengerName(name);
        assertEquals(expResult, result);

        // LONG STRING
        name = "PACO PEREZ PACO PEREZ PACO PEREZ PACO PEREZ PACO PEREZ PACO PEREZ PACO PEREZ PACO PEREZ PACO PEREZ PACO PEREZ "
                + "PACO PEREZ PACO PEREZ PACO PEREZ PACO PEREZ PACO PEREZ PACO PEREZ PACO PEREZ PACO PEREZ PACO PEREZ PACO PEREZ ";
        expResult = false;
        result = FileImportService.validatePassengerName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of validatePassengerEmail method, of class FileImportService.
     */
    @Test
    public void testValidatePassengerEmail() {
        System.out.println("validatePassengerEmail");

        // CORRECT EMAIL
        String email = "pepe@gmail.com";
        boolean expResult = true;
        boolean result = FileImportService.validatePassengerEmail(email);
        assertEquals(expResult, result);

        // EMPTY EMAIL
        email = " ";
        expResult = true;
        result = FileImportService.validatePassengerEmail(email);
        assertEquals(expResult, result);

        // INCOMPLETE EMAIL
        email = "pepe";
        expResult = false;
        result = FileImportService.validatePassengerEmail(email);
        assertEquals(expResult, result);

        // INCOMPLETE EMAIL
        email = "pepe@";
        expResult = false;
        result = FileImportService.validatePassengerEmail(email);
        assertEquals(expResult, result);

        // INCOMPLETE EMAIL
        email = "pepe@gmail";
        expResult = false;
        result = FileImportService.validatePassengerEmail(email);
        assertEquals(expResult, result);

        // INCOMPLETE EMAIL
        email = "@gmail";
        expResult = false;
        result = FileImportService.validatePassengerEmail(email);
        assertEquals(expResult, result);

        // INCOMPLETE EMAIL
        email = "@gmail.com";
        expResult = false;
        result = FileImportService.validatePassengerEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateMovements method, of class FileImportService.
     */
    @Test
    public void testValidateMovements() {
        System.out.println("validateMovements");

        // CORRECT
        String movements = "FLRFFFFFLLLRRR";
        boolean expResult = true;
        boolean result = FileImportService.validateMovements(movements);
        assertEquals(expResult, result);

        // INCORRECT
        movements = "FLRFFFF AAII";
        expResult = false;
        result = FileImportService.validateMovements(movements);
        assertEquals(expResult, result);
    }
}