import csv
with open("target/site/jacoco/jacoco.csv", 'r') as file:
    csv_file = csv.DictReader(file)
    missed_lines = 0
    covered_lines = 0
    for row in csv_file:
        covered_lines += int(row['LINE_COVERED'])
        missed_lines += int(row['LINE_MISSED'])    
    print(round((covered_lines * 100) / (missed_lines + covered_lines), 2))
