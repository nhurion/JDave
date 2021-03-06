/*
 * Copyright 2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jdave.tools;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jdave.support.IO;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Joni Freeman
 */
public class FileStoreTest {
    private IDoxStore store;
    private File file;
    
    @Before
    public void setUp() throws Exception {
        store = new FileStore("target/jdave") {
            @Override
            protected File newFile(File dir, String name) throws IOException {
                file = File.createTempFile(name, "", dir);
                return file;
            }
        };
    }
    
    @Test
    public void testCreatesFileBySpecName() throws FileNotFoundException, IOException {
        store.store("Test", "txt", "content");
        assertTrue(file.exists());
        assertEquals("content", IO.read(new FileInputStream(file)));
    }
}
