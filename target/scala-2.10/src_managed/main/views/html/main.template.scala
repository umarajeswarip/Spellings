
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>


<html>
    <head>
        <title>"""),_display_(Seq[Any](/*8.17*/title)),format.raw/*8.22*/("""</title>
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png"))),format.raw/*9.97*/("""">
        <link href=""""),_display_(Seq[Any](/*10.22*/routes/*10.28*/.Assets.at("bootstrap/css/bootstrap.css"))),format.raw/*10.69*/("""" rel="stylesheet">
        <style type="text/css">
            div.source_pos
            """),format.raw/*13.13*/("""{"""),format.raw/*13.14*/("""
            position:absolute;
            left:20px;
            top:150px;
            width: 300px;
            """),format.raw/*18.13*/("""}"""),format.raw/*18.14*/("""
            div.dest_pos
            """),format.raw/*20.13*/("""{"""),format.raw/*20.14*/("""
            position:absolute;
            left:600px;
            top:150px;
            width: 300px;
            """),format.raw/*25.13*/("""}"""),format.raw/*25.14*/("""
            div.but_pos
            """),format.raw/*27.13*/("""{"""),format.raw/*27.14*/("""
            position:absolute;
            left:500px;
            top:350px;
            """),format.raw/*31.13*/("""}"""),format.raw/*31.14*/("""
            div.gen_but_pos
            """),format.raw/*33.13*/("""{"""),format.raw/*33.14*/("""
            position:absolute;
            left:450px;
            top:650px;
            """),format.raw/*37.13*/("""}"""),format.raw/*37.14*/("""
        </style>
        <link href=""""),_display_(Seq[Any](/*39.22*/routes/*39.28*/.Assets.at("bootstrap/css/bootstrap-responsive.css"))),format.raw/*39.80*/("""" rel="stylesheet">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*40.54*/routes/*40.60*/.Assets.at("stylesheets/main.css"))),format.raw/*40.94*/("""">
        <script src=""""),_display_(Seq[Any](/*41.23*/routes/*41.29*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*41.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*42.23*/routes/*42.29*/.Assets.at("javascripts/app.js"))),format.raw/*42.61*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*43.23*/routes/*43.29*/.Spellings.jsRoutes)),format.raw/*43.48*/("""" type="text/javascript"></script>
    </head>
    <body>
        <div class="navbar navbar-fixed-top">
          <div class="navbar-inner">
            <div class="container">
              <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </a>
              <a class="brand" href="/">Spelling</a>
            </div>
          </div>
        </div>
    
        <div class="container">
        """),_display_(Seq[Any](/*60.10*/content)),format.raw/*60.17*/("""
        </div>
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 12 01:05:28 GMT 2014
                    SOURCE: /home/dev/Downloads/Spellings/app/views/main.scala.html
                    HASH: fd7542ef7831686eea9a49f74b809486ead438b3
                    MATRIX: 560->1|684->31|773->85|799->90|901->157|915->163|968->195|1028->219|1043->225|1106->266|1225->357|1254->358|1398->474|1427->475|1493->513|1522->514|1667->631|1696->632|1761->669|1790->670|1909->761|1938->762|2007->803|2036->804|2155->895|2184->896|2259->935|2274->941|2348->993|2457->1066|2472->1072|2528->1106|2589->1131|2604->1137|2671->1182|2764->1239|2779->1245|2833->1277|2926->1334|2941->1340|2982->1359|3597->1938|3626->1945
                    LINES: 19->1|22->1|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|34->13|34->13|39->18|39->18|41->20|41->20|46->25|46->25|48->27|48->27|52->31|52->31|54->33|54->33|58->37|58->37|60->39|60->39|60->39|61->40|61->40|61->40|62->41|62->41|62->41|63->42|63->42|63->42|64->43|64->43|64->43|81->60|81->60
                    -- GENERATED --
                */
            