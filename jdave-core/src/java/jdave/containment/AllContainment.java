/*
 * Copyright 2006 the original author or authors.
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
package jdave.containment;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Joni Freeman
 */
public class AllContainment<T> extends CollectionContainment<T> {
    public AllContainment(final Collection<T> elements) {
        super(elements);
    }

    public AllContainment(final Iterator<T> elements) {
        super(elements);
    }

    public AllContainment(final Iterable<T> elements) {
        super(elements);
    }

    @Override
    public boolean nullSafeMatches(final Collection<T> actual) {
        return actual.containsAll(elements);
    }

}
