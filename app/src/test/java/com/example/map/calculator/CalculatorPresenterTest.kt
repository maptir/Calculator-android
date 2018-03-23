package com.example.map.calculator

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class CalculatorPresenterTest {
    lateinit var view: CalculatorView
    lateinit var presenter: CalculatorPresenter

    @Before
    fun init() {
        view = mock(CalculatorView::class.java)
        presenter = CalculatorPresenter(view)
    }

    @Test
    fun testStart() {
        presenter.start()
        verify(view).setDisplayValue("0")
    }
}