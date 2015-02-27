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

package org.apache.xmlbeans.xml.stream;

/**
 * Returns the document location of the event.  This is not
 * required to be exact and is informational only.
 * 
 *
 * @version 1.0
 *
 */
public interface Location {
  /*
   * returns the current column number
   *
   * @return integer value of the current column number
   */
  public int getColumnNumber(); 
  /*
   * returns the current line
   *
   * @return integer value of the current line number
   */
  public int getLineNumber();
  /*
   * returns the String value of the public ID
   *
   * @return public ID or null if not set
   */
  public String getPublicId(); 
  /*
   * returns the String value of the system ID
   *
   * @return system ID or null if not set
   */
  public String getSystemId();
}



