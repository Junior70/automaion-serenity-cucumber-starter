Feature: Adding todo items

  Rule: Users can add one

    @adding
    Example: Adding a single new
      Given Todd has an empty todo list new
      When he add new "Buy some milk"
      Then he should have the new
        | Buy some milk |