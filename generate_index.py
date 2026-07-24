import os
import csv
import urllib.parse

def generate_csv(root_dir, repo_url, output_file):
    with open(output_file, mode='w', newline='', encoding='utf-8') as file:
        writer = csv.writer(file)
        writer.writerow(['Topic', 'Question Name', 'File Path', 'GitHub Link'])
        
        for dirpath, dirnames, filenames in os.walk(root_dir):
            # Skip hidden directories like .git
            if '.git' in dirpath.split(os.sep):
                continue
                
            for filename in filenames:
                if filename.endswith('.java'):
                    filepath = os.path.join(dirpath, filename)
                    rel_path = os.path.relpath(filepath, root_dir)
                    rel_path_forward_slash = rel_path.replace('\\', '/')
                    
                    # Assuming the folder is the topic
                    topic = os.path.basename(dirpath)
                    question_name = os.path.splitext(filename)[0]
                    
                    # URL encode parts of the path that might have spaces or special characters
                    parts = rel_path_forward_slash.split('/')
                    encoded_parts = [urllib.parse.quote(part) for part in parts]
                    encoded_path = '/'.join(encoded_parts)
                    
                    github_link = f"{repo_url}/blob/main/{encoded_path}"
                    
                    writer.writerow([topic, question_name, rel_path, github_link])

if __name__ == '__main__':
    generate_csv('.', 'https://github.com/KSNauman/DSA-Java-pgms', 'DSA_Tracker.csv')
    print("DSA_Tracker.csv generated successfully.")
