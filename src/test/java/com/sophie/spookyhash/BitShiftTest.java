package test.java.com.sophie.spookyhash;


import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class BitShiftTest {

    @Test
    public void testBitShift() {
        assertThat(Integer.valueOf(123) << 0).isEqualTo(Integer.valueOf(123)); //pass
        assertThat(Integer.valueOf(123) << 32).isEqualTo(Integer.valueOf(123)); //pass
        assertThat(Integer.valueOf(0x00000000) << 4).isEqualTo(Integer.valueOf(0x00000000)); //pass
        assertThat(Integer.valueOf(0b1) << 3).isEqualTo(Integer.valueOf(0b1000)); //pass
        assertThat(Integer.valueOf(0xFFFFFFFF) << 5).isEqualTo(Integer.valueOf(0xFFFFFFFF)); // res -32, expected -1
        assertThat(Integer.valueOf(0xF0000000) << 4).isEqualTo(Integer.valueOf(0x0000000F)); // res 0, expected 15
    }
}
