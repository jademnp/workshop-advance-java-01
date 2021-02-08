import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularBufferTest {

    CircularBuffer circularBuffer = new CircularBuffer();

    @Test
    public void write_A_B_and_read_A_B_then_buffer_is_empty() {
        circularBuffer.create();
        circularBuffer.write("A");
        circularBuffer.write("B");
        circularBuffer.read();
        circularBuffer.read();
        assertTrue(circularBuffer.isEmpty());
    }

    @Test
    public void write_A_B_should_read_A_B() {
        circularBuffer.create();
        circularBuffer.write("A");
        circularBuffer.write("B");
        assertEquals("A", circularBuffer.read());
        assertEquals("B", circularBuffer.read());
    }

    @Test
    public void write_A_should_read_A() {
        circularBuffer.create();
        circularBuffer.write("A");
        String result = circularBuffer.read();
        assertEquals("A", result);
    }

    @Test
    @DisplayName("หลังจากสร้าง buffer แล้วเพิ่มข้อมูลเข้าไป ผลที่ได้ buffer ต้องไม่ว่าง")
    public void after_created_and_write_data_should_be_not_empty() {
        circularBuffer.create();
        circularBuffer.write("A");
        boolean status = circularBuffer.isEmpty();
        assertFalse(status);
    }

    @Test
    @DisplayName("หลังจากสร้าง buffer แล้ว buffer จะต้องว่างเสมอ")
    public void after_created_should_be_empty() {
        circularBuffer.create();
        boolean status = circularBuffer.isEmpty();
        assertTrue(status);
    }

    @Test
    @DisplayName("ขนาดของ CircularBuffer ต้องมีขนาดเท่ากับ 5")
    public void create_buffer_with_specified_size_5() {
        // Act
        circularBuffer.create(5);
        int size = circularBuffer.getSize();

        // Validate/Checking/Assert
        assertEquals(5, size);
    }

    @Test
    @DisplayName("ขนาด default ของ CircularBuffer ต้องมีขนาดเท่ากับ 10")
    public void create_buffer_with_default_size() {
        // Act
        circularBuffer.create();
        int size = circularBuffer.getSize();

        // Validate/Checking/Assert
        assertEquals(10, size);
    }

//    @Test
//    @DisplayName("สร้าง CircularBuffer ขนาด 4 และ write data 5 ตัว ตัวแรกต้องโดน overwrite")
//    public void overwrite_data_when_it_is_over_size() {
//        // Act
//        circularBuffer.create(4);
//        circularBuffer.write("1");
//        circularBuffer.write("2");
//        circularBuffer.write("3");
//        circularBuffer.write("4");
//        circularBuffer.write("5");
//
//        // Validate/Checking/Assert
//        assertEquals("1", circularBuffer.read());
//        assertEquals("2", circularBuffer.read());
//        assertEquals("3", circularBuffer.read());
//        assertEquals("4", circularBuffer.read());
//        assertEquals("5", circularBuffer.read());
//    }

    @Test
    @DisplayName("เมื่อมีการ write ครบ 5 ครั้ง CircularBuffer จะเต็ม")
    public void buffer_is_full_with_5_write() {
        // Act
        circularBuffer.create(5);
        circularBuffer.write("1");
        circularBuffer.write("2");
        circularBuffer.write("3");
        circularBuffer.write("4");
        circularBuffer.write("5");

        // Validate/Checking/Assert
        assertEquals(true, circularBuffer.isFull());
    }
}