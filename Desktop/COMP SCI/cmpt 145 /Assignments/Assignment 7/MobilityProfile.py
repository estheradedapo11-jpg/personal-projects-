# Esther Adedapo
# NSID: fxy319
# Student Number: 11366614
# Instructor: Alexander Dumais
# Lab Section: L02

import LocationNode as LN

class MobilityProfile(object):
    def __init__(self, aList=None):
        """
        Purpose: Creates a mobility profile. If no aList is given, profile is set to None.
        Pre-condition:
            aList: A list of five strings, showing the sequential locations that the user had visited.
        Post-condition: A mobility profile is created.
        Return: None
        """
        if aList is None:
            self.head = None
        else:
            self.create_profile(aList)

    def create_profile(self, aList):
        """
        Purpose:
            Creates a mobility profile using the given aList.
        Pre-conditions:
            aList: A list of five strings, showing the sequential locations that the user had visited.
            aList should only have five locations.
        Post-condition:
            A mobility profile is created.
        Return: None
        """
        if len(aList) != 5:
            raise ValueError("aList must contain exactly five locations.")

        self.head = LN.LocationNode(aList[0])
        current_node = self.head
        for location in aList[1:]:
            new_node = LN.LocationNode(location)
            current_node.set_next_location(new_node)
            current_node = new_node

    def compare_profile(self, otherProfile):
        """
        Purpose:
            Compare two mobility profiles. Return True when the two mobility profiles have at least one matching location.
        Pre-conditions:
            otherProfile: Another user's mobility profile for comparison.
            Both self and other profiles must not be None.
        Post-condition:
            None
        Return: True if there is a match, False otherwise.
        """
        current_self = self.head
        current_other = otherProfile.head

        while current_self is not None and current_other is not None:
            if current_self.get_current_location() == current_other.get_current_location():
                return True
            current_self = current_self.get_next_location()
            current_other = current_other.get_next_location()

        return False
