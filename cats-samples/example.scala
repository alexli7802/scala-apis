
// functor
//  - Option[A], Future[A], List[A]
trait Functor[F[_]] {

	def map[A,B](fa: F[A])(f: A=>B): F[B]
}

// contra-variant functor
//  - Printable[A] 
trait Contravariant[F[_]] {

	def contramap[A,B](fa: F[A])(f: B=>A): F[B]
}

object Contravariant {
	implicit def apply[F[_]](implicit c: Contravariant[F]): Contravariant[F]
}

// in-variant functor
//	- Codec[A]
trait Invariant[F[_]] {
	def imap[A,B](fa: F[A])(f: A=>B)(g: B=>A): F[B]
}

///////////////////////////////////////////////////////////////////////////////

trait Monoid[A] {

	def empty: A

	def combine(a1: A, a2: A): A
}

val stringMonoid: Monoid[String] = ???

val symbolMonoid: Monoid[Symbol] = ???




























