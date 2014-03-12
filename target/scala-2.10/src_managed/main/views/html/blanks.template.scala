
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
object blanks extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[models.Spelling],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(spellings: List[models.Spelling]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.36*/("""
"""),_display_(Seq[Any](/*2.2*/main("Welcome to Play 2.0")/*2.29*/ {_display_(Seq[Any](format.raw/*2.31*/("""
        <div>hello</div>

""")))})))}
    }
    
    def render(spellings:List[models.Spelling]): play.api.templates.HtmlFormat.Appendable = apply(spellings)
    
    def f:((List[models.Spelling]) => play.api.templates.HtmlFormat.Appendable) = (spellings) => apply(spellings)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 12 01:05:28 GMT 2014
                    SOURCE: /home/dev/Downloads/Spellings/app/views/blanks.scala.html
                    HASH: 53f589288c41b3a8d36b8aade5b260f96f74dd94
                    MATRIX: 572->1|700->35|736->37|771->64|810->66
                    LINES: 19->1|22->1|23->2|23->2|23->2
                    -- GENERATED --
                */
            