/**
 *   Copyright 2012 Quest Software, Inc.
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
 *   limitations under the License.
 */

package com.quest.oraoop;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OracleTablePartitions extends OraOopGenerics.ObjectList<OracleTablePartition> {

    public OracleTablePartition findPartitionByName(String partitionName) {

        OracleTablePartition result;

        Iterator<OracleTablePartition> iterator = this.iterator();
        while (iterator.hasNext()) {
            result = iterator.next();
            if (result.name.equals(partitionName))
                return result;
        }
        return null;
    }

    public OracleTablePartition findPartitionByRegEx(String regEx) {

        OracleTablePartition result;

        Pattern pattern = Pattern.compile(regEx);
        
        Iterator<OracleTablePartition> iterator = this.iterator();
        while (iterator.hasNext()) {
            result = iterator.next();
            Matcher matcher = pattern.matcher(result.name);
            if(matcher.find())
                return result;
        }
        return null;
    }

}