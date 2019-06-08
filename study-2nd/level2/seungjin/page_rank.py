import csv
import operator
from collections import defaultdict
nesteddict = defaultdict(dict)


out_val = {}
in_val = {}
in_link = defaultdict(dict)
pr_val = {}
d_pr_val = {}

count = 1002
d = 0.99


#nesteddict['abc']['spam'] = 'ham'
graph = defaultdict(dict)

#Reading
with open("data.csv",'r',) as csv_file:
    reader = csv.reader(csv_file)
    for row in reader:
        try:
            in_val[row[1]] +=1
        except KeyError:
            in_val[row[1]] = 1
        
        try:
            out_val[row[0]] +=1
        except KeyError:
            out_val[row[0]] = 1

        try:
            in_link[row[1]][row[0]] += 1
        except KeyError:
            in_link[row[1]][row[0]] = 1

        pr_val[row[0]] = 0
        pr_val[row[1]] = 0


for i in pr_val:
    pr_val[i] = 1/count



#print(in_link)

print(1/count)

# First 
for link in in_link:
    ip = link
    d_pr_val[ip] = (1-d)/count
    for connect_ip in in_link[ip]: #add link with node
        d_pr_val[ip] += (pr_val[connect_ip]/out_val[connect_ip])*d*in_link[ip][connect_ip]
    for ip in d_pr_val:
        pr_val[ip] = d_pr_val[ip]

    

#iterate
# Second ~ 
for i in range(0,500):
    for link in in_link:
        ip = link
        d_pr_val[ip] = (1-d)/count
        for connect_ip in in_link[ip]:
            d_pr_val[ip] += (pr_val[connect_ip]/out_val[connect_ip])*d*in_link[ip][connect_ip]
    for ip in d_pr_val:
        pr_val[ip] = d_pr_val[ip]



"""
# Second ~
for link in in_link:
    ip = link
    for connect_ip in in_link[ip]:
        try : 
            pr_val[ip] +=(pr_val[connect_ip] / out_val[connect_ip])*in_link[ip][connect_ip]
        except KeyError:
            pr_val[connect_ip] = initial_val/out_val[connect_ip]
            pr_val[ip] +=(pr_val[connect_ip] / out_val[connect_ip])*in_link[ip][connect_ip]
            

# First ~
for i in range(0,1000):
    for link in in_link:
        ip = link
        d_pr_val[ip] = (1-d)*initial_val
        for connect_ip in in_link[ip]:
            try :
                d_pr_val[ip] += (pr_val[connect_ip]/out_val[connect_ip])*d*in_link[ip][connect_ip]
            except KeyError:
                pr_val[connect_ip] = 0
                d_pr_val[ip] += (pr_val[connect_ip]/out_val[connect_ip])*d*in_link[ip][connect_ip]

    for ip in d_pr_val:
        pr_val[ip] = d_pr_val[ip]
"""



sorted = sorted(pr_val.items(), key=operator.itemgetter(1), reverse=True)

for i in range(0,30):
    #print("IP :" + i + "   value : " + pr_val[i])
    print(sorted[i])

