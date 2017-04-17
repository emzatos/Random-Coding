import requests

n = '9783161484100'
sting = 'https://www.amazon.com/s/ref=sr_fapo?rh=n%3A283155%2Cp_66%3A9783161484100&sort=relevanceexprank&unfiltered=1&ie=UTF8&qid=1492248579&fap=1'
x = requests.get(sting)
print(x.text)