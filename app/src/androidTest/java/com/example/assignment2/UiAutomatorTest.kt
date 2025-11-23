package com.example.assignment2

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.uiautomator.uiAutomator
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 26)
class UiAutomatorTest {

    @Test
    fun testStartExplicitActivityAndVerifyChallenge() = uiAutomator {


        startApp("com.example.assignment2")
        waitForAppToBeVisible("com.example.assignment2")


        onElement { text?.toString() == "Start Activity Explicitly" }.click()


        onElement { text?.toString() == "Device Fragmentation" }
    }
}
