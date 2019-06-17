# epoxy-shared-element-transition

Demonstrates how to perform a shared element transition of a list item across two fragments with [EpoxyRecyclerViews](https://github.com/airbnb/epoxy).

Some key discoveries/gotchas were:
 - `postponeEnterTransition()` has no effect unless `setReorderingAllowed(true)` is called on the fragment transaction
 - Contrary to what you might expect, a fragment's `exitTransition` is not used and has no effect if it is popped off the backstack. Rather, its `returnTransition` is used. If a `returnTransition` isn't set, it will fall back to using its `enterTransition`.
