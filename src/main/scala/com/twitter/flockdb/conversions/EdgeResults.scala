/*
 * Copyright 2010 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.twitter.flockdb.conversions

import com.twitter.gizzard.thrift.conversions.Sequences._
import com.twitter.results.ResultWindow
import conversions.Edge._


object EdgeResults {
  class RichResultWindowOfEdges(resultWindow: ResultWindow[Edge]) {
    def toEdgeResults = new thrift.EdgeResults(resultWindow.map { _.toThrift }.toJavaList,
                                               resultWindow.nextCursor.position, resultWindow.prevCursor.position)
  }
  implicit def richResultWindowOfEdges(resultWindow: ResultWindow[Edge]) =
    new RichResultWindowOfEdges(resultWindow)
}
