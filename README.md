# Romans-go-home

> In this repository you'll find **Romans Go Home**. This kata is to introduce yourself into the world of the regex, well known like Regular Expressions. This kata has been a really interesting kata to understand how the regexs works and how to build one by yourself just knowing the special syntax to do it. The kata is all based about, get an input that this input will be an actual roman number and the program has to convert into the correct decimal number. I really like how this kata is themed about. I decided to add to this program a roman number validator, that the input that the programs get before converted into a decimal number has to check that the got it roman number is well written following the special rules that the romans have created for their numbers.

## Table of Contents

1. [Motivation](#motivation)
1. [Used Technologies](#used-technologies)
1. [Rules](#rules)
1. [Reflections](#reflections)
1. [License](#license)

---

## Motivation

I've been so comfortable developing this kata because all was about to develop a regex that match the roman number and can converted into a decimal number. I've enjoyed because I could have seen myself trying to understand how the regex works and from non knowledge about them get to build one by yourself. I always liked the roman numbers or at least I've found really cool calculate with them and thanks to this kata I could comeback a bit to my childhood remembering how to write correctly the roman numbers and become and expert about the regex validations. 

---

**[⬆ back to top](#table-of-contents)**

## Used Technologies

- Java
- Junit
- Maven
- Jacoco
- MarkDown
- Github

---

**[⬆ back to top](#table-of-contents)**

## Rules

The rules for this kata are really simple and are explained below:

- The numbers are read from left to right
- Always you have to start from the symbols that have the highest value to the symbols that have the lowest value
- S symbol followed by another symbol that is the same one or one with a lower value always will be summative
- A symbol that is followed by another that has a higher value always will be subtractive and these two symbols should be treated like a group
- The symbol I and the symbols with base 10 --> (X, C and M) can be repeated up to three consecutive times
- The symbols with base 5 --> (V, L and D) can not be repeated, because their summative can be representated by another way using the rest of the symbols
- The symbol I and the symbols with base 10 (X, C and M) can appear being subtractive to another symbol having higher value, but following the next rules:
  1. Just can be subtractive with the numbers with base 5 and 10 with a higher value but not on another symbols with lower value
  2. In case of being subtractive they can not be repeated
- The symbols with base 5 can not be used to make subtractive groups

---

**[⬆ back to top](#table-of-contents)**

## Reflections

Thanks to this kata I got to understand how the regex works and the most important thing I've been able to build my own first regex. I think this kata is really useful and all programmer that is starting should do it once in their life because you'll learn the special syntax that you have to use to build a regex validation. And I really like to understand how the regex works because now every time I'm going to register into a new page or I fail a validation field in any kind of form I can understand straight way what has failed and why is failing and for first time I feel how important the regex are to all the stuff related about validation fields. Probably everyone at least once in his life will have to fight against the syntax of a regex or will have to study how to build one because being honest they're really important in our day by day.

---

**[⬆ back to top](#table-of-contents)**

## License

MIT License

Copyright (c) 2020 AntoniPizarro and Pau Llinàs

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

---

**[⬆ back to top](#table-of-contents)**
