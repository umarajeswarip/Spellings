// @SOURCE:/home/dev/Downloads/Spellings/conf/routes
// @HASH:adfd8bd8e837078f7df816ffbd49cb3bdbd781e1
// @DATE:Wed Mar 12 01:05:28 GMT 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Spellings_jsRoutes0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/js/routes"))))
        

// @LINE:7
private[this] lazy val controllers_Spellings_index1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:8
private[this] lazy val controllers_Spellings_generate2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("spellings/generate"))))
        

// @LINE:11
private[this] lazy val controllers_Assets_at3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/js/routes""","""controllers.Spellings.jsRoutes"""),("""GET""", prefix,"""controllers.Spellings.index"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """spellings/generate""","""controllers.Spellings.generate"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Spellings_jsRoutes0(params) => {
   call { 
        invokeHandler(controllers.Spellings.jsRoutes, HandlerDef(this, "controllers.Spellings", "jsRoutes", Nil,"GET", """""", Routes.prefix + """assets/js/routes"""))
   }
}
        

// @LINE:7
case controllers_Spellings_index1(params) => {
   call { 
        invokeHandler(controllers.Spellings.index, HandlerDef(this, "controllers.Spellings", "index", Nil,"GET", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:8
case controllers_Spellings_generate2(params) => {
   call { 
        invokeHandler(controllers.Spellings.generate, HandlerDef(this, "controllers.Spellings", "generate", Nil,"POST", """""", Routes.prefix + """spellings/generate"""))
   }
}
        

// @LINE:11
case controllers_Assets_at3(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     