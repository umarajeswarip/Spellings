
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object spellings extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[models.Spelling],String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(spellings: List[models.Spelling], activeSort: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.56*/("""
"""),_display_(Seq[Any](/*2.2*/main("Welcome to Play 2.0")/*2.29*/ {_display_(Seq[Any](format.raw/*2.31*/("""
<div id="sort">
    <span>Sort by:</span>
    <ul class="nav nav-pills">
        <li """),_display_(Seq[Any](/*6.14*/if(activeSort == "name")/*6.38*/{_display_(Seq[Any](format.raw/*6.39*/("""class="active"""")))})),format.raw/*6.54*/("""><a href=""""),_display_(Seq[Any](/*6.65*/routes/*6.71*/.Spellings.index)),format.raw/*6.87*/("""?sort=name">title</a></li>
    </ul>
</div>
  <table>
  <tr><td> <div id="source_select_div" class="source_pos">
    <div class="span12">
      <h2>Available Words</h2>
      """),_display_(Seq[Any](/*13.8*/if(spellings.isEmpty)/*13.29*/ {_display_(Seq[Any](format.raw/*13.31*/("""
        <p>No articles available yet.</p>
      """)))}/*15.9*/else/*15.14*/{_display_(Seq[Any](format.raw/*15.15*/("""
        <select id="source_select" multiple="multiple" size="20"/>
        """),_display_(Seq[Any](/*17.10*/spellings/*17.19*/.map/*17.23*/ { spelling =>_display_(Seq[Any](format.raw/*17.37*/("""
        """),_display_(Seq[Any](/*18.10*/if( spelling.name != null)/*18.36*/ {_display_(Seq[Any](format.raw/*18.38*/("""
            <option value=""""),_display_(Seq[Any](/*19.29*/spelling/*19.37*/.name)),format.raw/*19.42*/("""">"""),_display_(Seq[Any](/*19.45*/spelling/*19.53*/.name)),format.raw/*19.58*/("""</option>
        """)))})),format.raw/*20.10*/("""
        """)))})),format.raw/*21.10*/("""
        </select>
        </div>
      </div>
      </td>
       <td>
        <div id="button_div" class="but_pos">
            <input id="button" type="button" value=">>" />
        </div>
        </td>
        <td>
        <div id="dest_select_div" class="dest_pos">
            <h2>Words To Generate Fill in the blanks</h2>
            <select id="dest_select" multiple="multiple" size="20">
                </select>
        </div>
        </td></tr></table>
    <div id="gen_button_div" class="gen_but_pos">
        <input id="gen_button" type="button" value="Generate" />
    </div>

<div id="gen_output">
</div>
      """)))})),format.raw/*44.8*/("""
    </table>
    </div>
  </div>
""")))})))}
    }
    
    def render(spellings:List[models.Spelling],activeSort:String): play.api.templates.HtmlFormat.Appendable = apply(spellings,activeSort)
    
    def f:((List[models.Spelling],String) => play.api.templates.HtmlFormat.Appendable) = (spellings,activeSort) => apply(spellings,activeSort)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 12 01:05:28 GMT 2014
                    SOURCE: /home/dev/Downloads/Spellings/app/views/spellings.scala.html
                    HASH: 672710fca36e7f56f5d1eef99fcee526d20c16fc
                    MATRIX: 582->1|730->55|766->57|801->84|840->86|962->173|994->197|1032->198|1078->213|1124->224|1138->230|1175->246|1386->422|1416->443|1456->445|1524->496|1537->501|1576->502|1689->579|1707->588|1720->592|1772->606|1818->616|1853->642|1893->644|1958->673|1975->681|2002->686|2041->689|2058->697|2085->702|2136->721|2178->731|2836->1358
                    LINES: 19->1|22->1|23->2|23->2|23->2|27->6|27->6|27->6|27->6|27->6|27->6|27->6|34->13|34->13|34->13|36->15|36->15|36->15|38->17|38->17|38->17|38->17|39->18|39->18|39->18|40->19|40->19|40->19|40->19|40->19|40->19|41->20|42->21|65->44
                    -- GENERATED --
                */
            