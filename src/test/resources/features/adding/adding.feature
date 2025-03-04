Feature: Adding todo items

  Rule: Users can add one

    @adding
    Example: Adding a single
      Given Toddhas an empty todo list
      When he add "Buy some milk"
      Then he should have the
        | Buy some milk |