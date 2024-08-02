"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lab Section: L02"""


def factorial(n):
    def fact_helper(i, prod):
        if i == n:
            return i * prod
        else:
            return fact_helper(i + 1, i * prod)

    if n == 0:
        return 1
    else:
        return fact_helper(1, 1)


if __name__ == '__main__':
    print("A simple demo for factorial")

    inputs = [0, 1, 2, 3, 4, 5, 6]
    expected = [1, 1, 2, 6, 24, 120, 720]
    for (ip, ex) in zip(inputs, expected):
        result = factorial(ip)
        if result != ex:
            print("Error: factorial of", ip, "returned", result, "but", ex, "was expected")
        else:
            print("factorial of", ip, "returned", result)

