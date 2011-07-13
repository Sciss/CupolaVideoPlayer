package de.sciss.cupola.video

import swing.{Dialog, Frame}

object Util {
   def displayError( parent: Frame, title: String, e: Throwable ) {
      Dialog.showMessage( Option( parent ).flatMap( _.contents.headOption ).orNull, "An error occurred:\n" +
         abbreviateStackTrace( e ), title, Dialog.Message.Error )
   }

   def abbreviateStackTrace( e: Throwable, maxLine: Int = 16 ) : String = {
      val sb      = new StringBuffer( e.getClass.getName + " : " + e.getLocalizedMessage + "\n" )
      val trace   = e.getStackTrace
      val num     = math.min( maxLine, trace.length )
      var i = 0; while( i < num ) {
         sb.append( "\tat " + trace( i ) + "\n" )
      i += 1 }
      if( trace.length > num ) {
         sb.append( "\t...\n" )
      }
      sb.toString
   }
}