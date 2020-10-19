import org.junit.Test

import org.junit.Assert.*
import sun.applet.Main

class MainKtTest {

    @Test
    fun calcVkCommission_VkPay() {
        val aTransferSum = 100_00
        val aMonthSum = 0
        val aCardType = "Vk Pay"

        val result = calcVkCommission(
            transferSum = aTransferSum,
            monthSum = aMonthSum,
            cardType = aCardType
        )

        assertEquals(0, result)
    }

    @Test
    fun calcVkCommission_MastercardMaestroBelow75K() {
        assertEquals(
            0, calcVkCommission(
                transferSum = 888_00,
                monthSum = 50_000_00,
                cardType = "Mastercard Maestro"
            )
        )
    }

    @Test
    fun calcVkCommission_MastercardMaestroOver75K() {
        assertEquals(
            2533, calcVkCommission(
                transferSum = 888_00,
                monthSum = 90_000_00,
                cardType = "Mastercard Maestro"
            )
        )
    }

    @Test
    fun calcVkCommission_VisaMirBelow35Rub() {
        assertEquals(
            3500, calcVkCommission(
                transferSum = 1_000_00,
                monthSum = 0,
                cardType = "Visa Mir"
            )
        )
    }

    @Test
    fun calcVkCommission_VisaMirOver35Rub() {
        assertEquals(
            7500, calcVkCommission(
                transferSum = 10_000_00,
                monthSum = 0,
                cardType = "Visa Mir"
            )
        )
    }

    @Test
    fun calcVkCommission_UnknownCard() {
        assertEquals(
            0, calcVkCommission(
                transferSum = 1,
                monthSum = 0,
                cardType = "UnknownCard"
            )
        )
    }

    @Test
    fun calcVkCommission_DefaultCall() {
        assertEquals(
            0, calcVkCommission(
                transferSum = 1
            )
        )
    }

    @Test
    fun calcVkCommission_DefaultCall2() {
        assertEquals(
            0, calcVkCommission(
                transferSum = 1,
                monthSum = 1_000
            )
        )
    }

}