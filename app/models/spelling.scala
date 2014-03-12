package models

import org.jboss.netty.buffer._
import org.joda.time.DateTime
import play.api.data._
import play.api.data.Forms._
import play.api.data.format.Formats._
import play.api.data.validation.Constraints._
import play.api.Logger

import reactivemongo.bson._
import java.util

case class Spelling(
                    id: Option[BSONObjectID],
                    name: String,
                    syllable: String,
                    totalSyllables: String,
                    sentences: BSONArray
                    )
// Turn off your mind, relax, and float downstream
// It is not dying...
object Spelling {
  implicit object SpellingBSONReader extends BSONDocumentReader[Spelling] {
    def read(doc: BSONDocument): Spelling = {
      val id = doc.getAs[BSONObjectID]("_id")
      val name = doc.getAs[String]("name").get
      val syllable = doc.getAs[String]("syllable").get
      val totalSyllables =doc.getAs[String]("totalSyllables").get
      val sentences =doc.getAs[String]("sentences").get
      Logger.info(s"name: $name")
      Logger.info(s"syllable: $syllable")
      Logger.info(s"id: $id")
      Logger.info(s"totalSyllables: $totalSyllables")
      Logger.info(s"sentences: $sentences")
      Spelling(
        doc.getAs[BSONObjectID]("_id"),
        doc.getAs[String]("name").get,
        doc.getAs[String]("syllable").get,
        doc.getAs[String]("totalSyllables").get,
        doc.getAs[BSONArray]("sentences").get)

    }
  }
  implicit object SpellingBSONWriter extends BSONDocumentWriter[Spelling] {
    def write(spelling: Spelling): BSONDocument =
      BSONDocument(
        "_id" -> spelling.id.getOrElse(BSONObjectID.generate),
        "name" -> spelling.name,
        "syllable" -> spelling.syllable,
        "totalSyllables" -> spelling.totalSyllables,
        "sentences" -> spelling.sentences)
  }
  val form = Form(
    mapping(
      "id" -> optional(of[String] verifying pattern(
        """[a-fA-F0-9]{24}""".r,
        "constraint.objectId",
        "error.objectId")),
      "name" -> nonEmptyText,
      "syllable" -> text,
      "totalSyllables" -> text
      ) { (id, name, syllable, totalSyllables) =>
      Spelling(
        id.map(new BSONObjectID(_)),
        name,
        syllable,
        totalSyllables, null)
    } { spelling =>
      Some(
        (spelling.id.map(_.stringify),
          spelling.name,
          spelling.syllable,
          spelling.totalSyllables
          ))
    })
}