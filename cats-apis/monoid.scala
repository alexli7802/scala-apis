
//////////////////////////////////////////////////////////////////////////////////////////////
//                                      Semigroup                                           //
//////////////////////////////////////////////////////////////////////////////////////////////
package cats.kernel

trait Semigroup[A] {

	// all instances need to implement 'combine()'
	abstract def combine(a1: A, a2: A): A
}

/*
object Semigroup {

	// returns 'a Semigroup instance for type A'
	final def apply[A](implicit ev: Semigroup[A]): Semigroup[A]
}
*/

//--------------------------------------------------------------------------------------------
package cats.syntax

final class SemigroupOps[A] {

	new SemigroupOps(lhs: A)(implicit ev: Semigroup[A])

	macro def combine(rhs: A): A;
	macro def combineN(rhs: Int): A;
	macro def |+|(rhs: A): A;
}

trait SemigroupSyntax {
	implicit final def catsSyntaxSemigroup[A](a: A)(implicit ev: Semigroup[A]): SemigroupOps[A]
}

object semigroup extends SemigroupSyntax {

	implicit final def catsSyntaxSemigroup[A](a: A)(implicit ev: Semigroup[A]): SemigroupOps[A]
}

//////////////////////////////////////////////////////////////////////////////////////////////
//                                         Monoid                                           //
//////////////////////////////////////////////////////////////////////////////////////////////
package cats.kernel

trait Monoid[A] {

	abstract def combine(a1: A, a2: A): A;
	abstract def empty: A
}

object Monoid {

	// returns 'a Monoid instance for type A'
	final def apply[A](implicit ev: Monoid[A]): Monoid[A]
}

//--------------------------------------------------------------------------------------------
package cats.syntax

final class MonoidOps[A] {

	new MonoidOps(lhs: A)

	def isEmpty(implicit m: Monoid[A], eq: Eq[A]): Boolean
}


trait MonoidSyntax extends SemigroupSyntax {

	implicit final def catsSyntaxSemigroup[A](a: A)(implicit ev: Semigroup[A]): SemigroupOps[A]
	implicit final def catsSyntaxMonoid[A](a: A)(implicit m: Monoid[A]): MonoidOps[A]
}

object monoid {

	implicit final def catsSyntaxMonoid[A](a: A)(implicit m: Monoid[A]): MonoidOps[A]
	implicit final def catsSyntaxSemigroup[A](a: A)(implicit ev: Semigroup[A]): SemigroupOps[A]
}
