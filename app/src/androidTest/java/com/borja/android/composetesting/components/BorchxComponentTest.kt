package com.borja.android.composetesting.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelectable
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.doubleClick
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performScrollToNode
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipe
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import androidx.compose.ui.test.swipeUp
import org.junit.Rule
import org.junit.Test

class BorchxComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest(){
        composeTestRule.setContent {
            BorchxComponent()
        }
        //Finder
        composeTestRule.onNodeWithText("Borchx", ignoreCase = true)
        composeTestRule.onNodeWithTag("component1")
        composeTestRule.onNodeWithContentDescription("superImage")

        composeTestRule.onAllNodesWithTag("component1")//coge todos los que tengan el mismo tag
        composeTestRule.onAllNodesWithText(":")
        composeTestRule.onAllNodesWithContentDescription("visualIcon")

        //Actions
        composeTestRule.onNodeWithText("Borchx", ignoreCase = true).performClick()
        composeTestRule.onAllNodesWithTag("component1").onFirst().performClick()
        composeTestRule.onNodeWithText("Borchx").performTouchInput {
            doubleClick()
            longClick()
            swipeDown()
            swipeUp()
            swipeLeft()
            swipeRight()
        }
        composeTestRule.onNodeWithText("Borchx").performScrollTo()
        composeTestRule.onNodeWithText("Borchx").performImeAction()
        composeTestRule.onNodeWithText("Borchx").performTextClearance()
        composeTestRule.onNodeWithText("Borchx").performTextInput("Texto nuevo")
        composeTestRule.onNodeWithText("Borchx").performTextReplacement("Texto que remplaza")
        composeTestRule.onNodeWithText("Borchx").performScrollTo().performClick().performImeAction()


        //Assertions
        composeTestRule.onNodeWithText("Borchx").assertExists()
        composeTestRule.onNodeWithText("Borchx").assertDoesNotExist()
        composeTestRule.onNodeWithText("Borchx").assertContentDescriptionContains("Borchx")
        composeTestRule.onNodeWithText("Borchx").assertContentDescriptionEquals("Borchx")
        composeTestRule.onNodeWithText("Borchx").assertIsDisplayed()
        composeTestRule.onNodeWithText("Borchx").assertIsNotDisplayed()
        composeTestRule.onNodeWithText("Borchx").assertIsEnabled()
        composeTestRule.onNodeWithText("Borchx").assertIsNotEnabled()
        composeTestRule.onNodeWithText("Borchx").assertIsSelectable()
        composeTestRule.onNodeWithText("Borchx").assertIsNotSelected()
        composeTestRule.onNodeWithText("Borchx").assertIsFocused()
        composeTestRule.onNodeWithText("Borchx").assertIsNotFocused()
        composeTestRule.onNodeWithText("Borchx").assertIsOn()
        composeTestRule.onNodeWithText("Borchx").assertIsOff()
        composeTestRule.onNodeWithText("Borchx").assertTextEquals("")
        composeTestRule.onNodeWithText("Borchx").assertTextContains("Borchx")

    }

    @Test
    fun whenComponentStart_thenVerifyContentIsBorchx(){
        composeTestRule.setContent {
            BorchxComponent()
        }
        composeTestRule.onNodeWithText("Borchx", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithTag("textFieldName").assertTextContains("Borchx")
    }

    @Test
    fun whenNameIsAdded_thenVerifyTextContainGreeting(){
        composeTestRule.setContent {
            BorchxComponent()
        }
        composeTestRule.onNodeWithTag("textFieldName").performTextClearance()
        composeTestRule.onNodeWithTag("textFieldName").performTextReplacement("Pepe")
        composeTestRule.onNodeWithTag("textGreeting").assertTextEquals("Te llamas Pepe")
    }
}