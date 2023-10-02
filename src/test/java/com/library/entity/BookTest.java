package com.library.entity;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BookTest {

    @Test
    public void testSetForeignWord() {
        Book book = new Book();
        book.setAuthor("test");
        assertTrue(book.getAuthor() == "test");
    }

}
