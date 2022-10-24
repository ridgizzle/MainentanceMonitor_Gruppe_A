package fhtw.bic.maintenancemonitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceMonitorTest {

    @Test
    public static void checkAdd(){
        //Arrange
        Maintenancemonitor rechner = new Maintenancemonitor();

        //Act
        long summe = rechner.add(2, 2);

        //Assert
        assertEquals(4, summe);
    }

}