import urllib.request
import json
import time

COMMIT = "16b634018a4a47a69a850568143845f68f16ff3b"
URL = f"https://api.github.com/repos/sahilsync07/skilonline/actions/runs?head_sha={COMMIT}"

def poll_until_completion(max_attempts=30, delay=15):
    for attempt in range(1, max_attempts + 1):
        print(f"\n--- Poll Attempt {attempt}/{max_attempts} ---")
        try:
            req = urllib.request.Request(URL, headers={'User-Agent': 'Python'})
            res = urllib.request.urlopen(req)
            data = json.loads(res.read().decode('utf-8'))
            
            runs = data.get('workflow_runs', [])
            if not runs:
                print("No workflow runs found yet for commit.")
                time.sleep(delay)
                continue

            all_completed = True
            all_success = True

            for run in runs:
                run_name = run['name']
                status = run['status']
                conclusion = run['conclusion']
                print(f"Workflow: '{run_name}' | Status: {status} | Conclusion: {conclusion}")
                
                if status != 'completed':
                    all_completed = False
                if conclusion != 'success':
                    all_success = False

                jobs_url = run['jobs_url']
                jreq = urllib.request.Request(jobs_url, headers={'User-Agent': 'Python'})
                jres = urllib.request.urlopen(jreq)
                jdata = json.loads(jres.read().decode('utf-8'))
                
                for job in jdata.get('jobs', []):
                    jname = job['name']
                    jstatus = job['status']
                    jconclusion = job['conclusion']
                    print(f"    Job: '{jname}' -> Status: {jstatus} | Conclusion: {jconclusion}")

            if all_completed:
                print(f"\nFINAL VERDICT: All workflows completed! All Success = {all_success}")
                return all_completed, all_success
            
        except Exception as e:
            print(f"Error during poll: {e}")
            
        time.sleep(delay)

    print("\nPolling timed out before all workflows completed.")
    return False, False

if __name__ == '__main__':
    poll_until_completion()
