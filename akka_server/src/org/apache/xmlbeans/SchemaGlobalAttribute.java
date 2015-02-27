/*   Copyright 2004 The Apache Software Foundation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.xmlbeans;

/**
 * Represents a global attribute definition
 * 
 * @see SchemaTypeLoader#findAttribute
 */ 
public interface SchemaGlobalAttribute extends SchemaLocalAttribute, SchemaComponent
{
    /**
     * The name of the source .xsd file within which this attribute was defined
     */ 
    String getSourceName();

    /**
     * Used to allow on-demand loading of elements.
     * 
     * @exclude
     */
    public final static class Ref extends SchemaComponent.Ref
    {
        public Ref(SchemaGlobalAttribute element)
            { super(element); }

        public Ref(SchemaTypeSystem system, String handle)
            { super(system, handle); }

        public final int getComponentType()
            { return SchemaComponent.ATTRIBUTE; }

        public final SchemaGlobalAttribute get()
            { return (SchemaGlobalAttribute)getComponent(); }
    }

    /**
     * Retruns a SchemaGlobalElement.Ref pointing to this element itself.
     */
    public Ref getRef();

}
