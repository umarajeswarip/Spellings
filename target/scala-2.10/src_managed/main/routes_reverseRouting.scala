// @SOURCE:/home/dev/Downloads/Spellings/conf/routes
// @HASH:adfd8bd8e837078f7df816ffbd49cb3bdbd781e1
// @DATE:Wed Mar 12 01:05:28 GMT 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseSpellings {
    

// @LINE:8
def generate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "spellings/generate")
}
                                                

// @LINE:7
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:6
def jsRoutes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/js/routes")
}
                                                
    
}
                          

// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseSpellings {
    

// @LINE:8
def generate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Spellings.generate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "spellings/generate"})
      }
   """
)
                        

// @LINE:7
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Spellings.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:6
def jsRoutes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Spellings.jsRoutes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/js/routes"})
      }
   """
)
                        
    
}
              

// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:8
// @LINE:7
// @LINE:6
class ReverseSpellings {
    

// @LINE:8
def generate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Spellings.generate(), HandlerDef(this, "controllers.Spellings", "generate", Seq(), "POST", """""", _prefix + """spellings/generate""")
)
                      

// @LINE:7
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Spellings.index(), HandlerDef(this, "controllers.Spellings", "index", Seq(), "GET", """""", _prefix + """""")
)
                      

// @LINE:6
def jsRoutes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Spellings.jsRoutes(), HandlerDef(this, "controllers.Spellings", "jsRoutes", Seq(), "GET", """""", _prefix + """assets/js/routes""")
)
                      
    
}
                          

// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
        
    