### About
This is an attempt to model domain in semantic shapes.

### Problem
Let's say we try to model `User` domain. 

`User` has attributes: `id, first, last, address`.
 
`Address` has attributes: `city, zip, state`.

If we try to implement the following functions:
- `createUser(first, last, address.city, address.zip, address.state): ExistingUser`
- `greet(UserWithName): String`
- `userGeo(UserWithIdAndAddressZip)`
- `getUserWithoutAddress(): UserWithoutAddress`
- `getUser(): User`

We quickly realize that:
1. We get a combinatorial explosion in data classes proliferation
2. Every class is not compatible with each other. For example `User` has to inherit `UserWithoutAddress`. So that in places where function expects `UserWithoutAddress` we should be able to provide `User`.
3. To make them compatible we also have to write interfaces for each of them.

### Inspirations:
- Clojure [Schema](https://github.com/plumatic/schema) (see [Rich Hickey talk](https://www.youtube.com/watch?v=YR5WdGrpoug) and this [article](https://medium.com/@functionalhuman/functional-programing-with-cats-105d666b260e))
- [Elixir](https://elixir-lang.org/) type system

### Ideas to explore:
- Look at [Manifold](http://manifold.systems/docs.html#structural-interfaces), maybe it makes sense to integrate with them or at least borrow some ideas
- [Structural typing in Java](https://github.com/alexbezhan/stjava)
