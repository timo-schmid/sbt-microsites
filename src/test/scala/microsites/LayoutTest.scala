/*
 * Copyright 2016 47 Degrees, LLC. <http://www.47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package microsites

import microsites.domain.MicrositeSettings
import microsites.layouts.Layout
import microsites.util.Arbitraries
import org.scalatest.prop.Checkers
import org.scalacheck.Prop._
import org.scalatest.{FunSuite, Matchers}

import scalatags.Text.TypedTag
import scalatags.Text.all._

class LayoutTest extends FunSuite with Checkers with Matchers with Arbitraries {

  test("meta should never be empty") {

    val property = forAll { settings: MicrositeSettings ⇒
      lazy val layout = new Layout(settings) {
        override def render: TypedTag[String] = html
      }

      layout.metas should not be empty
      layout.metas.nonEmpty
    }

    check(property)
  }
}
